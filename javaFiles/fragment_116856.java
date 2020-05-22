import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TestAudio {

    public static void main(String[] args) {
        ReentrantLock lockWait = new ReentrantLock();
        Condition conWait = lockWait.newCondition();
        try {
            new Sound("...", new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType().equals(LineEvent.Type.STOP)) {
                        System.out.println("Line has stopped");
                        lockWait.lock();
                        try {
                            conWait.signal();
                        } finally {
                            lockWait.unlock();
                        }
                    }
                }
            });
            System.out.println("Waiting for audio to finish");
            lockWait.lock();
            try {
                conWait.await();
            } finally {
                lockWait.unlock();
            }
            System.out.println("Audio has finished");
        } catch (InterruptedException | LineUnavailableException | IOException | UnsupportedAudioFileException exp) {
            exp.printStackTrace();
        }
    }

    public static class Sound {

        private Clip play;

        public Sound(String s, LineListener listener) throws InterruptedException, LineUnavailableException, IOException, UnsupportedAudioFileException {
            play = null;
            File in = new File(s);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
            play = AudioSystem.getClip();
            play.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType().equals(LineEvent.Type.STOP)) {
                        System.out.println("Audio stopped, closing clip");
                        play.close();
                    }
                }
            });
            play.addLineListener(listener);
            play.open(audioInputStream);
            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(1.0f); // Reduce volume by 10 decibels.
            play.start();
        }
    }

}