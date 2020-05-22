import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Point2D pointAt(double radians, double radius) {
            double x = radius * Math.cos(radians);
            double y = radius * Math.sin(radians);

            return new Point2D.Double(x, y);
        }

        protected Point2D translate(Point2D point, Point2D to) {
            Point2D newPoint = new Point2D.Double(point.getX(), point.getY());
            newPoint.setLocation(point.getX() + to.getX(), point.getY() + to.getY());
            return newPoint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLACK);

            double startAngle = 0;
            double divisions = 12;
            double delta = 360.0 / divisions;

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(centerX, centerY) * 2; // Overshoot the visible bounds

            Point2D centerPoint = new Point2D.Double(centerX, centerY);
            double angle = startAngle;
            for (int index = 0; index < divisions; index++) {
                Point2D point = pointAt(Math.toRadians(angle), radius);
                point = translate(point, centerPoint);
                g2d.draw(new Line2D.Double(centerPoint, point));
                angle += delta;
            }

            g2d.dispose();
        }

    }

}