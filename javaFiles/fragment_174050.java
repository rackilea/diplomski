import java.awt.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CornerTest {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CornerTest window = new CornerTest();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CornerTest() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final GeneralPath gp = new GeneralPath();
        MyGeneralPath path = new MyGeneralPath(gp);
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(100, 50);
//        path.lineTo(50, 100);
        path.flush();


        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setStroke(new BasicStroke(15.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.setColor(Color.BLACK);
                g2d.draw(gp);
            }
        };
        frame.setBackground(Color.CYAN);
        frame.add(panel);
    }

    static class MyGeneralPath
    {
        private GeneralPath path;
        private List<Point2D.Double> points = new ArrayList<Point2D.Double>();

        public MyGeneralPath(GeneralPath path)
        {
            this.path = path;
        }

        public void moveTo(double x, double y)
        {
            flush();
            points.add( new Point2D.Double(x, y) );
        }

        public void lineTo(double x, double y)
        {
            Point2D.Double point = new Point2D.Double(x, y);

            checkSlope(point);

            points.add( point );
        }

        private void checkSlope(Point2D.Double p3)
        {
            int size = points.size();

            if (size < 2 )
                return;

            Point2D.Double p2 = points.get(size - 1);
            Point2D.Double p1 = points.get(size - 2);

            double slope1 = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
            double slope2 = (p3.getY() - p2.getY()) / (p3.getX() - p2.getX());

            if (slope1 == slope2)
                moveTo(p2.getX(), p2.getY());
        }

        public void flush()
        {
            int size = points.size();

            if (size == 0)
                return;

            Point2D.Double point = points.get(0);
            path.moveTo(point.getX(), point.getY());

            for (int i = 1; i < size; i++)
            {
                point = points.get(i);
                path.lineTo(point.getX(), point.getY());
            }

            points.clear();
        }
    }
}