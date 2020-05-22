import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class SoundTest{

private ArrayList<Clip> clips = new ArrayList<Clip>();

// Constructor
public void Run(String pen)throws InterruptedException {
JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setTitle("Test Sound");
f.setSize(300, 200);
f.setVisible(false);       

try {
     // Open an audio input stream.           
      File soundFile = new File(pen); 
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
      Clip clip = AudioSystem.getClip();

     clip.open(audioIn);
     clip.start();
     clips.add(clip);
  } catch (UnsupportedAudioFileException e) {
     e.printStackTrace();
  } catch (IOException e) {
     e.printStackTrace();
  } catch (LineUnavailableException e) {
     e.printStackTrace();
  }
 }
 public boolean stop(int id) {
    if (clips.get(id-1) != null) {
        clips.get(id-1).stop();
        return true;
    }
    return false;
}
}