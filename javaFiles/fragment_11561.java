import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

public enum SoundEffect  {


    BUSY("resources/phone-busy.wav"),   
    CALLING("resources/phone-calling.wav"),         
    DISCONNECT("resources/phone-disconnect.wav"),
    RING("resources/telephone-ring.wav");  

    // Each sound effect has its own clip, loaded with its own sound file.
    private Clip clip;
    private URL url;
    private AudioInputStream audioInputStream;

    // Constructor to construct each element of the enum with its own sound file.
    SoundEffect(String soundFileName) {
        try {
            // Use URL (instead of File) to read from disk and JAR.
            this.url = this.getClass().getClassLoader().getResource(soundFileName);
            // Set up an audio input stream piped from the sound file.
            this.audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Play or Re-play the sound effect from the beginning, by rewinding.
    public void play() {

        clip.loop(Clip.LOOP_CONTINUOUSLY); 

    }

    public void stop(){

        clip.stop();   // Stop the player if it is still running
        clip.flush();
        clip.setFramePosition(0);
    }

    // Optional static method to pre-load all the sound files.
    static void init() {
        values(); // calls the constructor for all the elements
    }

    public boolean isActive(){

        return clip.isActive();
    }

    public boolean isOpen() {

        return clip.isOpen();
    }

    public void setFramePosition() {
        clip.setFramePosition(0);

    }

}