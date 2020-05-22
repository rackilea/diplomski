import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ActiveWindowScreenShot
{
 /**
  * Main method
  * 
  * @param args (not used)
  */
 public static void main(String[] args)
 {
  Robot robot;

  try {
   robot = new Robot();
  } catch (AWTException e) {
   throw new IllegalArgumentException("No robot");
  }

  // Press Alt + PrintScreen
  // (Windows shortcut to take a screen shot of the active window)
  robot.keyPress(KeyEvent.VK_ALT);
  robot.keyPress(KeyEvent.VK_PRINTSCREEN);
  robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
  robot.keyRelease(KeyEvent.VK_ALT);

  System.out.println("Image copied.");
 }
}