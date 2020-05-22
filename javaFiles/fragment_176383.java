public class TestRobotKeys {

    private Robot robot;

    public static void main(String[] args) {
        new TestRobotKeys();
    }

    public TestRobotKeys() {
        try {
            robot = new Robot();
            robot.setAutoDelay(250);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }

}