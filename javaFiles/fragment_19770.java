import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                Shape shape = new OvalShape(new Rectangle(25, 24, 50, 50), true, Color.RED);

                ShapeContainer container = new ShapeContainer();
                container.add(shape);

                frame.add(container);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface Shape {
        public Rectangle getBounds();
        public boolean isFilled();
        public Color getColor();
        public void paint(Graphics2D g2d);
    }

    public abstract class AbstractShape implements Shape {
        private Rectangle bounds;
        private boolean filled;
        private Color color;

        public AbstractShape(Rectangle bounds, boolean filled, Color color) {
            this.bounds = bounds;
            this.filled = filled;
            this.color = color;
        }

        public Rectangle getBounds() {
            return bounds;
        }

        public boolean isFilled() {
            return filled;
        }

        public Color getColor() {
            return color;
        }

    }

    public class OvalShape extends AbstractShape {

        public OvalShape(Rectangle bounds, boolean filled, Color color) {
            super(bounds, filled, color);
        }

        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(this.getColor());
            Rectangle bounds = getBounds();
            if (isFilled()) {
                g2d.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
            } else {
                g2d.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
            }
        }

    }

    public class ShapeContainer extends JPanel {
        private List<Shape> shapes;

        public ShapeContainer() {
            shapes = new ArrayList<>(25);
        }

        public void add(Shape shape) {
            shapes.add(shape);
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape shape : shapes) {
                Graphics2D g2d = (Graphics2D) g.create();
                shape.paint(g2d);
                g2d.dispose();
            }
        }



    }
}