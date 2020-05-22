import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestColorGrab {

    private static Robot robot;

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(TestColorGrab.class.getName()).log(Level.SEVERE, null, ex);
        }
        new TestColorGrab();
    }

    public TestColorGrab() {
        Rectangle bounds = new Rectangle(0, 0, 10, 10);
        long start = System.currentTimeMillis();
        scanImageArea(bounds);
        System.out.println("Took " + ((System.currentTimeMillis() - start) / 1000), TimeUnit.SECONDS) + " seconds to scan image");

        start = System.currentTimeMillis();
        scanRobotArea(bounds);
        System.out.println("Took " + ((System.currentTimeMillis() - start) / 1000) + " seconds to scan screen");
    }

    public static int getColor(int x, int y) {
        try {
            return (robot.getPixelColor(x, y).getRGB() * -1);
        } catch (Exception e) {
            System.out.println("getColor ERROR");
            return 0;
        }
    }

    public static void scanRobotArea(Rectangle searchArea) {
        for (int i = searchArea.x; i < searchArea.x + searchArea.width; i++) {
            for (int j = searchArea.y; j < searchArea.y + searchArea.height; j++) {
                getColor(i, j);
            }
        }
    }

    public static void scanImageArea(Rectangle searchArea) {
        BufferedImage image = robot.createScreenCapture(searchArea);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.getRGB(x, y);
            }
        }
    }

}