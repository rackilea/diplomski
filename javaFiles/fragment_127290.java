import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Test {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        try {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}