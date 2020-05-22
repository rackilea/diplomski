import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
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
                    UIManager.setLookAndFeel(UIManager
                                    .getSystemLookAndFeelClassName());
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

            Boolean hovering = false;
            Boolean resizing = true;

            private Point clickPoint;
            private Rectangle originalBounds;

            @Override
            public void mouseMoved(MouseEvent e) {
                mousePoint = e.getPoint();
                for (int i = 0; i < shapes.size(); i++) {
                    Path2D shape = shapes.get(i);
                    Rectangle2D bottomRight = getActiveBounds(-45,
                                    shape.getBounds());

                    if (mousePoint != null) {

                        if (bottomRight.contains(mousePoint)) {
                            Cursor cursor = Cursor
                                            .getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                            setCursor(cursor);
                            hovering = true;
                        } else {
                            Cursor cursor = Cursor
                                            .getPredefinedCursor(Cursor.DEFAULT_CURSOR);
                            setCursor(cursor);
                            hovering = false;
                        }
                    }
                }

                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (hovering) {
                    resizing = true;
                    System.out.println("Starting to resize");
                    clickPoint = e.getPoint();
                    originalBounds = new Rectangle(shapes.get(currentIndex).getBounds());
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (resizing && clickPoint != null) {

                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    int xDelta = mouseX - clickPoint.x;
                    int yDelta = mouseY - clickPoint.y;

                    int delta = Math.max(xDelta, yDelta);

                    Rectangle bounds = shapes.get(currentIndex).getBounds();
                    int shapeX = bounds.x;
                    int shapeY = bounds.y;

                    int shapeWidth = originalBounds.width + delta;
                    int shapeHeight = originalBounds.height + delta;

                    if (shapeWidth < 0) {
                        shapeWidth *= -1;
                        shapeX = originalBounds.x - shapeWidth;
                    }
                    if (shapeHeight < 0) {
                        shapeHeight *= -1;
                        shapeY = originalBounds.y - shapeHeight;
                    }

                    System.out.printf("%d %dx%dx%dx%d%n", delta, shapeX, shapeY, shapeWidth, shapeHeight);

                    shapes.get(currentIndex).reset();
                    shapes.get(currentIndex).append(
                                    new Ellipse2D.Double(shapeX, shapeY, shapeWidth, shapeHeight), true);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (resizing) {
                    System.out.println("Done resizing");
                    resizing = false;
                    clickPoint = null;
                    originalBounds = null;
                }
            }

        }
    }

}