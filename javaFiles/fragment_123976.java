import javax.sound.sampled.*;
import java.io.File;

/**
 * By Maytham on 07-10-2016.
 */
public class Sound {

    public static void main(String[] args) {
        playSound("8k16bitpcm.wav", SoundOptions.Play);
    }

    // 1) make it private
    private static Thread dj;

    // 2) make it private and 3) SoundOptions should be final
    private static synchronized void playSound(final String url, final SoundOptions mode) {
        dj = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            new File("assets" + File.separator + url));

                    // 4) declare AudioSystem in stead of using AudioSystem repeatedly
                    final Clip audioLineClip = (Clip) AudioSystem.getLine(
                            new Line.Info(Clip.class));
                    audioLineClip.open(inputStream);
                    audioLineClip.setFramePosition(0);

                    // 5) our line listener checks when audio is ended and stops the line
                    //this is full example, but you manipulated your way
                    audioLineClip.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                            LineEvent.Type type = event.getType();
                            if (type == LineEvent.Type.OPEN) {
                            } else if (type == LineEvent.Type.CLOSE) {
                                System.exit(0);
                            } else if (type == LineEvent.Type.START) {
                            } else if (type == LineEvent.Type.STOP) {
                                audioLineClip.close();
                            }
                        }
                    });

                    switch (mode) {
                        case Stop:
                            audioLineClip.stop();
                            break;
                        case Play:
                            audioLineClip.start();
                            break;
                        case Loop:
                            audioLineClip.loop(Clip.LOOP_CONTINUOUSLY);
                            break;
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        if (mode != SoundOptions.Stop) {
            dj.start();

            // 6) this keep the thread until some line listener change status
            synchronized (dj) {
                while (true) {
                    try {
                        dj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {
            dj.interrupt();

            // 7) you do not need this it is done by line listener
            /*try {
                AudioSystem.getClip().stop();
                AudioSystem.getClip().close();
                dj.interrupt();
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/

        }
    }
}