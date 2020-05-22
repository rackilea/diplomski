import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class RectangleDrawWithDrag extends JPanel{
    private static final int D_W = 500;
    private static final int D_H = 500;

    private Point p1;
    private Point p2;
    private Rectangle2D rectangle;

    public RectangleDrawWithDrag() {
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                p1 = e.getPoint();
                rectangle = new Rectangle2D.Double(p1.x, p1.y, p1.x - p1.x, p1.y - p1.y);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e) {
                p2 = e.getPoint();
                if (isPointTwoInQuadOne(p1, p2)) {
                    rectangle.setRect(p2.x, p2.y, p1.x - p2.x, p1.y - p2.y);
                } else {
                    rectangle.setRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);
                }

                repaint();
            }
        });
    }

    public boolean isPointTwoInQuadOne(Point p1, Point p2) {
        return p1.x >= p2.x && p1.y >= p2.y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if (rectangle != null) {
            g2.fill(rectangle);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new RectangleDrawWithDrag());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}