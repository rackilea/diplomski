public class Stop extends JFrame {

    static Robot robot = null;
    static Rectangle bounds = new Rectangle(300, 300, 300, 300);
    static int lastX = 450; static int lastY = 450;

    Stop() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        addMouseMotionListener(new MouseStop());

        getContentPane().add(new JLabel("<html>A sticky situation<br>Hold SHIFT to get out of it", JLabel.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(bounds);
        setVisible(true);
    }

    private static class MouseStop extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {

            if(e.isShiftDown()) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }
            else
                robot.mouseMove(lastX, lastY);
        }
    }

    public static void main(String args[]) {

        new Stop();
    }
}