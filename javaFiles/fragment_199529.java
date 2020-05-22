import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Editor {

    public static void main(String[] args) {
        new Editor();
    }

    public Editor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new UMLWindow();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(30, 30, 1000, 700);
                frame.getContentPane().setBackground(Color.white);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class UMLWindow extends JFrame {

        Shapes shapeList = new Shapes();
        Panel panel;

        private static final long serialVersionUID = 1L;

        public UMLWindow() {
            addMenus();
            panel = new Panel();
        }

        public void addMenus() {

            getContentPane().add(shapeList);

            setSize(300, 200);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            shapeList.addCircle(100, 100);
        }
    }

// Shapes class, used to draw the shapes on the panel
// as well as implements the MouseListener for dragging
    public static class Shapes extends JPanel {

        private static final long serialVersionUID = 1L;

        private List<Path2D> shapes = new ArrayList<Path2D>();
        int currentIndex;

        private Point mousePoint;

        public Shapes() {
            MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
            addMouseListener(myMouseAdapter);
            addMouseMotionListener(myMouseAdapter);
        }

        public void addCircle(int width, int height) {
            Path2D circ = new Path2D.Double();
            circ.append(new Ellipse2D.Double(442, 269, width, height), true);
            shapes.add(circ);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            for (Path2D shape : shapes) {
                g2.setColor(Color.BLACK);
                g2.draw(shape);

                g2.setColor(Color.RED);
                Rectangle2D bottomRight = getActiveBounds(-45, shape.getBounds());

                g2.draw(bottomRight);
                if (mousePoint != null) {

                    if (bottomRight.contains(mousePoint)) {
                        g2.fill(bottomRight);
                    }

                }

            }
        }

        public Rectangle2D getActiveBounds(float angel, Rectangle bounds) {

            Point2D p = getPointOnEdge(angel, bounds);

            return new Rectangle2D.Double(p.getX() - 4, p.getY() - 4, 8, 8);

        }

        public Point2D getPointOnEdge(float angel, Rectangle bounds) {

            float radius = Math.max(bounds.width, bounds.height) / 2;

            float x = radius;
            float y = radius;

            double rads = Math.toRadians((angel + 90));

            // Calculate the outter point of the line
            float xPosy = (float) (x + Math.cos(rads) * radius);
            float yPosy = (float) (y + Math.sin(rads) * radius);

            return new Point2D.Float(xPosy + bounds.x, yPosy + bounds.y);

        }

        class MyMouseAdapter extends MouseAdapter {

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePoint = e.getPoint();
                repaint();
            }

        }
    }

}