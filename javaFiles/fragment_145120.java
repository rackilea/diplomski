import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class PlaybackWAV {
    private final int BUFFER_SIZE = 128000;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private boolean running = false;

    /**
     * @param filename
     *            the name of the file that is going to be played
     */
    public synchronized void playSound(final String filename) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    InputStream audioSrc = this.getClass().getResourceAsStream(filename);
                    // add buffer for mark/reset support
                    InputStream bufferedIn = new BufferedInputStream(audioSrc);
                    audioStream = AudioSystem.getAudioInputStream(bufferedIn);

                    audioFormat = audioStream.getFormat();

                    DataLine.Info info = new DataLine.Info(
                            SourceDataLine.class, audioFormat);
                    sourceLine = (SourceDataLine) AudioSystem.getLine(info);
                    sourceLine.open(audioFormat);

                    sourceLine.start();
                    running = true;

                    while (running) {
                        audioStream.mark(BUFFER_SIZE);
                        int nBytesRead = 0;
                        byte[] abData = new byte[BUFFER_SIZE];
                        while (nBytesRead != -1) {
                            try {
                                nBytesRead = audioStream.read(abData, 0,
                                        abData.length);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (nBytesRead >= 0) {
                                sourceLine.write(abData, 0, nBytesRead);
                            }
                        }
                        if (running)
                            audioStream.reset();
                    }
                    sourceLine.drain();
                    sourceLine.close();
                } catch (Exception e) {
                    System.err
                            .printf("Exception occured while trying to playback file '%s'. (%s)%n",
                                    filename, e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stopSound() {
        this.running = false;
        if (sourceLine != null) {
            sourceLine.stop();
            sourceLine.drain();
            sourceLine.close();
        }
    }
}