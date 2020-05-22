package MyProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyStroke {
    private static Robot robot;

    public static void main(String[] args) throws AWTException {
        robot = new Robot();
        robot.delay(3000);
        keystroke(KeyEvent.VK_Q);
        keystroke(KeyEvent.VK_W);
        keystroke(KeyEvent.VK_E);
        keystroke(KeyEvent.VK_R);
        keystroke(KeyEvent.VK_T);
        keystroke(KeyEvent.VK_Y);
    }

    private static void keystroke(int key) {
        robot.keyPress(key);
        robot.delay(100); // hold for a tenth of a second, adjustable
        robot.keyRelease(key);
    }
}