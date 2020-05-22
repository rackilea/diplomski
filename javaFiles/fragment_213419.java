import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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

        private Long startTime;
        private long playTime = 2000;

        private Point startPoint, endPoint;
        private Point pointOnTimeLine;
        private double pointInTime; // For rendering...

        public TestPane() {
            startPoint = new Point(0, 95);
            endPoint = new Point(190, 95);
            pointOnTimeLine = new Point(startPoint);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime == null) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    long diff = now - startTime;
                    if (diff >= playTime) {
                        diff = playTime;
                        ((Timer) e.getSource()).stop();
                    }
                    double i = (double) diff / (double) playTime;
                    pointInTime = i;

                    pointOnTimeLine.x = (int) (startPoint.x + ((endPoint.x - startPoint.x) * i));
                    pointOnTimeLine.y = (int) (startPoint.y + ((endPoint.y - startPoint.y) * i));

                    repaint();
                }
            });

            timer.start();
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
            g2d.fill(new Ellipse2D.Double(startPoint.x, startPoint.y, 10, 10));
            g2d.fill(new Ellipse2D.Double(endPoint.x, endPoint.y, 10, 10));
            g2d.setColor(Color.GREEN);
            g2d.fill(new Ellipse2D.Double(pointOnTimeLine.x, pointOnTimeLine.y, 10, 10));
            g2d.dispose();
        }

    }

}