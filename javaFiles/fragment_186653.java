public class MouseRunner implements Runnable {

    @Override
    public void run() {
        try {
            Robot robot = new Robot();
            while (go) {
                robot.mouseMove(500, 500);
                robot.delay(1000);
                robot.mouseMove(500, 400);
            }
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}