import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;

public class ScreenshotUsingPrintScreen {

    public static void main(String[] args) throws Exception {
        int i = KeyEvent.VK_PRINTSCREEN;
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor[] flavors = cb.getAvailableDataFlavors();
        System.out.println("Before: ");
        for (DataFlavor flavor : flavors) {
            System.out.println(flavor);
        }

        // get the screenshot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
        robot.delay(40);
        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
        robot.delay(40);

        cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        flavors = cb.getAvailableDataFlavors();
        System.out.println("After: ");
        for (DataFlavor flavor : flavors) {
            System.out.println(flavor);
        }
    }
}