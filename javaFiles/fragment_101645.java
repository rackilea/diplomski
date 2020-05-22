import javax.sound.sampled.*;
import java.io.File;

public class Main  implements LineListener {
private boolean done = false;
public  void update(LineEvent event) {
    if(event.getType() == LineEvent.Type.STOP || event.getType() == LineEvent.Type.CLOSE) {
      done = true;
    }
}

public void waitonfinish() throws InterruptedException {
   while(!done) {
       Thread.sleep(1000);
   } 
}
public static  void playSound(final String url) {

    try {
      Clip clip = AudioSystem.getClip();
      AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
      Main control = new Main();
      clip.addLineListener(control);
      clip.open(inputStream);
      clip.start();
      control.waitonfinish();

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

public static void main(String[] args) {
    // TODO code application logic here
    playSound("C:\\warning_test.wav");   
 }
}