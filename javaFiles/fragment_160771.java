import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        try {
            new Test();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public Test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Sound longBeep = new Sound(new File(...));
        Sound shortBeep = new Sound(new File(...));

        List<Sound> message = new ArrayList<Sound>(9);
        message.add(shortBeep);
        message.add(shortBeep);
        message.add(shortBeep);
        message.add(longBeep);
        message.add(longBeep);
        message.add(longBeep);
        message.add(shortBeep);
        message.add(shortBeep);
        message.add(shortBeep);

        play(message);
    }

    public void play(List<Sound> message) {
        try {
            List<Sound> queue = new ArrayList<>(message);
            Transmit transmit = new Transmit(message);
            Thread thread = new Thread(transmit);
            thread.start();
            transmit.waitFor();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public class Transmit implements Runnable {

        private List<Sound> queue;
        private ReentrantLock lock;
        private Condition playCondition;

        public Transmit(List<Sound> message) {
            this.queue = new ArrayList<>(message);

            lock = new ReentrantLock();
            playCondition = lock.newCondition();
        }

        @Override
        public void run() {
            playNext();
        }

        public void waitFor() throws InterruptedException {
            lock.lock();
            if (!queue.isEmpty()) {
                try {
                    playCondition.await();
                } finally {
                    lock.unlock();
                }
            } else {
                lock.unlock();
            }
        }

        protected void playNext() {
            if (queue.size() > 0) {
                lock.lock();
                try {
                    System.out.println("Play Next");
                    Sound sound = queue.remove(0);
                    sound.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                            if (event.getType().equals(LineEvent.Type.STOP)) {
                                sound.removeLineListener(this);
                                System.out.println("Audio Completed");
                                playNext();
                            }
                        }
                    });
                    sound.play();
                } finally {
                    lock.unlock();
                }
            } else {
                lock.lock();
                try {
                    playCondition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public class Sound {

        private Clip audio;

        public Sound(AudioInputStream audioInputStream) throws LineUnavailableException, IOException {
            audio = AudioSystem.getClip();
            audio.open(audioInputStream);
        }

        public Sound(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            this(AudioSystem.getAudioInputStream(file));
        }

        public Sound(URL url) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            this(AudioSystem.getAudioInputStream(url));
        }

        public Sound(InputStream stream) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            this(AudioSystem.getAudioInputStream(stream));
        }

        public void close() {
            Objects.requireNonNull(audio, "Audio Clip has not been initalised");
            audio.close();
        }

        public void play() {
            Objects.requireNonNull(audio, "Audio Clip has not been initalised");
            audio.setFramePosition(0);
            audio.start();
        }

        public void addLineListener(LineListener listener) {
            Objects.requireNonNull(audio, "Audio Clip has not been initalised");
            audio.addLineListener(listener);
        }

        public void removeLineListener(LineListener listener) {
            Objects.requireNonNull(audio, "Audio Clip has not been initalised");
            audio.removeLineListener(listener);
        }
    }

}