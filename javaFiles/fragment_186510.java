import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;    
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudibleListener implements SomeListener {

private Runnable successRunner;
private Runnable failRunner;

ExecutorService pool = Executors.newCachedThreadPool();

/**
 * Call this after initialization and after every change in your config at runtime.
 */
public void reloadSettings() {
    // put your configuration here
    this.successRunner = new WavePlayer(this.getClass().getResource("success.wav"));
    this.failRunner = new WavePlayer(this.getClass().getResource("fail.wav"));
}

/**
 * Call this to savely shutdown the thread pool.
 */
public void shutdown() {
    this.pool.shutdown();
}

/**
 * Listener method called on success. 
 */
public void eventSuccess() {
    this.pool.execute(this.successRunner);
}

/**
 * Listener method called on fail. 
 */
public void eventFailed() {
    this.pool.execute(this.failRunner);
}

private class WavePlayer implements Runnable {

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

    private URL soundFile;

    public WavePlayer(URL soundFile) {
        this.soundFile = soundFile;
    }

    @Override
    public void run() {

        try {
            // check if the URL is still accessible!
            this.soundFile.openConnection().connect();
            this.soundFile.openStream().close();
        } catch (Exception e) {
            return;
        }

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem
                    .getAudioInputStream(this.soundFile);
        } catch (UnsupportedAudioFileException e) {
            return;
        } catch (IOException e) {
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) {
            return;
        } catch (Exception e) {
            return;
        }

        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[this.EXTERNAL_BUFFER_SIZE];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream
                        .read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (IOException e) {
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }
}
}