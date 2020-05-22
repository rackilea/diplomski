import java.applet.*;
import java.net.*;
public class MainClass {
public static void main(String[] args) {
  try {
     AudioClip clip = Applet.newAudioClip(
                    new URL("file:C:/sound.wav"));
     clip.play();
  } catch (MalformedURLException murle) {
  murle.printStackTrace();
}}}