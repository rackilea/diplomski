import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RadiusDrawer {
    private JFrame frame;
    private int centerX = 50;
    private int centerY = 50;
    private int x = 0;
    private int y = 0;
    private int r = 100;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new RadiusDrawer()::createAndShowGui);
    }

    private void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        frame.add(new MyCircle());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("serial")
    class MyCircle extends JPanel {
        int cx = 0;
        int cy = 0;
        public MyCircle() {
            int angle = 0;

            x = (int) (r * Math.cos(Math.toRadians(angle)));
            y = (int) (r * Math.sin(Math.toRadians(angle)));

            y *= -1; //We must inverse the Y axis since in Math Y axis starts in the bottom while in Swing it starts at the top, in order to have or angles correctly displayed, we must inverse the axis

            calculateCenter();
        }

        private void calculateCenter() {
            cx = centerX + r;
            cy = centerY + r;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            drawCircle(g2d, centerX, centerY, r);
            drawRadius(g2d);
        }

        private void drawCircle(Graphics2D g2d, int x, int y, int r) {
            g2d.setColor(Color.BLACK);
            g2d.draw(new Ellipse2D.Double(x, y, r * 2, r * 2));
        }

        private void drawRadius(Graphics2D g2d) {
            g2d.setColor(Color.BLUE);
            g2d.draw(new Line2D.Double(cx, cy, cx + x, cy + y));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }
}