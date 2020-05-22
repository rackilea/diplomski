import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        private Rectangle selection = new Rectangle();
        private Point clickPoint;

        public TestPane() {
            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseDragged(MouseEvent e) {
                    int minX = Math.min(e.getX(), clickPoint.x);
                    int minY = Math.min(e.getY(), clickPoint.y);
                    int maxX = Math.max(e.getX(), clickPoint.x);
                    int maxY = Math.max(e.getY(), clickPoint.y);

                    selection.x = minX;
                    selection.y = minY;
                    selection.width = maxX - minX;
                    selection.height = maxY - minY;
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
            Graphics2D g2d = (Graphics2D) g.create();
            if (selection.width > 0 && selection.height > 0) {
                g2d.setColor(new Color(0, 0, 255, 64));
                g2d.fill(selection);
                g2d.setColor(Color.BLUE);
                g2d.draw(selection);
            }
            g2d.dispose();
        }
    }

}