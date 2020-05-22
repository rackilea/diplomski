import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SelectionExample {

    public static void main(String[] args) {
        new SelectionExample();
    }

    public SelectionExample() {
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

        private Point clickPoint;

        private Shape shape;
        private Rectangle box;

        public TestPane() {
            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseDragged(MouseEvent e) {
                    int minX = Math.min(e.getX(), clickPoint.x);
                    int minY = Math.min(e.getY(), clickPoint.y);
                    int maxX = Math.max(e.getX(), clickPoint.x);
                    int maxY = Math.max(e.getY(), clickPoint.y);

                    box = new Rectangle(minX, minY, maxX - minX, maxY - minY);
                    int size = Math.min(maxX - minX, maxY - minY);
                    if (minX < clickPoint.x) {
                        minX = clickPoint.x - size;
                    }
                    if (minY < clickPoint.y) {
                        minY = clickPoint.y - size;
                    }

                    shape = new Ellipse2D.Double(minX, minY, size, size);
                    repaint();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    clickPoint = new Point(e.getPoint());
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shape != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 255, 64));
                g2d.fill(shape);
                g2d.setColor(Color.BLUE);
                g2d.draw(shape);
                g2d.draw(box);
                g2d.dispose();
            }
        }
    }

}