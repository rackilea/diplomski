import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class MainClass {
  public static void main(String[] args) {
    try {
      URL url = new URL("file:zvuk.wav" );
      AudioClip ac = Applet.newAudioClip(url);
      ac.play();

      System.out.println("Press any key to exit.");
      System.in.read();
      ac.stop();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}