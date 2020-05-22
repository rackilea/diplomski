import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawLine {

    public static void main(String[] args) {
        new DrawLine();
    }

    public DrawLine() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Point p1 = new Point(50, 50);
        private Point p2 = new Point(150, 150);

        public TestPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (double t = 0; t < 1; t += 0.01) {

                Point2D p = between(p1, p2, t);
                g2d.fillRect((int)p.getX(), (int)p.getY(), 5, 5);

            }
            g2d.dispose();
        }

        public Point2D between(Point p1, Point p2, double time) {

            double deltaX = p2.getX() - p1.getX();
            double deltaY = p2.getY() - p1.getY();

            double x = p1.getX() + time * deltaX;
            double y = p1.getY() + time * deltaY;

            return new Point2D.Double(x, y);

        }
    }

}