public class Main {

    static Timer timer;

    Main() {
        JFrame frame = new JFrame("Hello sample");
        frame.setSize(new Dimension(550, 550));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new MyPanel();
        frame.add(panel);
        frame.setVisible(true);
        timer = new Timer(5, (e) -> panel.repaint());
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    class MyPanel extends JPanel {
        int x = 200, y0 = 300, y = 0, w = 200, h = 200, v = -8;
        double t = 0.0, gravity = 9.8;
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            y = (int) (y0 + v * t + .5 * gravity * t * t);
            if (y > 300) {
                y = y0 = 300;
                // To prevent it from stopping comment the timer.stop() and 
                // uncomment the t = 0.0 statements.
                //t = 0.0;
                timer.stop();
            } else {
                y0 = y;
                t += .025;
            }
            g.drawOval(x, y, w, h);
        }
    }
}