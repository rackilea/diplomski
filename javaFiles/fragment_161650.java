import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

        private List<Drawing> drawings;
        private Drawing current;

        private Random rnd = new Random();

        public TestPane() {
            drawings = new ArrayList<>(25);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Stroke stroke = new BasicStroke(rnd.nextInt(9) + 1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                    Color color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
                    current = new Drawing(stroke, color);
                    current.addPoint(e.getPoint());
                    drawings.add(current);
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    current.addPoint(e.getPoint());
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Drawing drawing : drawings) {
                drawing.paint(g2d);
            }
            g2d.dispose();
        }

    }

    public class Drawing {

        private Stroke stroke;
        private Color color;
        private List<Point> points;

        public Drawing(Stroke stroke, Color color) {
            this.stroke = stroke;
            this.color = color;
            this.points = new ArrayList<>(25);
        }

        public void addPoint(Point p) {
            points.add(p);
        }

        public void paint(Graphics2D g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.setStroke(stroke);
            if (!points.isEmpty()) {
                Point from = points.get(0);
                for (Point to : points.subList(1, points.size())) {
                    g2d.draw(new Line2D.Double(from, to));
                    from = to;
                }
            }
            g2d.dispose();
        }

    }

}