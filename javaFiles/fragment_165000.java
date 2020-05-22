import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
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

        private List<List<Point>> points = new ArrayList<>(25);
        private List<Point> activeList;

        public TestPane() {
            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {

                    if (activeList != null) {
                        activeList.add(e.getPoint());
                        repaint();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    activeList = new ArrayList<>(25);
                    points.add(activeList);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (activeList != null && activeList.isEmpty()) {
                        points.remove(activeList);
                    }
                    activeList = null;
                }

            };
            addMouseMotionListener(ma);
            addMouseListener(ma);
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
            for (List<Point> group : points) {
                Point previous = null;
                for (Point p : group) {
                    // You can get rid of this, it's simply to show
                    // where the points would actually be rendered
                    g2d.fill(new Ellipse2D.Float(p.x - 2, p.y - 2, 4, 4));
                    if (previous != null) {
                        g2d.draw(new Line2D.Float(previous, p));
                    }
                    previous = p;
                }
            }
            g2d.dispose();
        }

    }

}