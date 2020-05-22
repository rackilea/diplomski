import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new ViewPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class ViewPanel extends JPanel {

        private static int APP_WIDTH = 600;
        private static int APP_HEIGHT = 400;

        private static final long serialVersionUID = -8019663913250286271L;

        public ViewPanel() {
            setBackground(Color.GRAY);
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
        }

        public void init() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(APP_HEIGHT, APP_HEIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            render(g);
        }

        // Where I do the drawing. It's called from the rendering loop in the JFrame
        public void render(Graphics g) {

            // refresh the background since we're not relying on paintComponent all the time
            Color bgc = getBackground();
            g.setColor(bgc);
            g.fillRect(0, 0, APP_WIDTH, APP_HEIGHT);

            // just paint a moving box
            drawBox(g);

            // draw a line to prove correctness. In the loop, you can see part of this line is hidden
            // underneath the title bar
            g.setColor(Color.red);
            g.drawLine(0, 0, APP_WIDTH, APP_HEIGHT);
        }

        protected void drawBox(Graphics g) {

            // get a random color
            Random ran = new Random();
            int red = ran.nextInt(255);
            int grn = ran.nextInt(255);
            int ble = ran.nextInt(255);
            Color colour = new Color(red, grn, ble);
            g.setColor(colour);

            // get a random position        
            int x = ran.nextInt(APP_WIDTH - 50);
            int y = ran.nextInt(APP_HEIGHT - 50);

            // draw it
            g.fillRect(x, y, 50, 50);
        }
    }
}