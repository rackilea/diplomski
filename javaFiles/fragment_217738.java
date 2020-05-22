import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//...

public static void main(String[] args) throws Throwable {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(SoundManager.class.getResourceAsStream("C://temp/my.mp3"));
        clip.open(inputStream);
        clip.start(); 
    }