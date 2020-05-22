import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DemoShapes {
    public static final Color DEFAULT_COLOR = Color.BLUE;

    public DemoShapes() {
        List<ShapeItem> shapes = new ArrayList<ShapeItem>();
        shapes.add(new ShapeItem(new Rectangle2D.Double(110, 1, 100, 100),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Rectangle2D.Double(110, 110, 100, 100),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1, 1, 100, 100),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Ellipse2D.Double(1, 110, 100, 100),
                DEFAULT_COLOR));

        JFrame frame = new JFrame("Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShapesPanel panel = new ShapesPanel(shapes);
        frame.add(panel);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    class ShapeItem {
        private Shape shape;
        private Color color;

        public ShapeItem(Shape shape, Color color) {
            super();
            this.shape = shape;
            this.color = color;
        }

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    class ShapesPanel extends JPanel {
        private List<ShapeItem> shapes;
        private Random rand = new Random();

        public ShapesPanel(List<ShapeItem> shapesList) {
            this.shapes = shapesList;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    Color color = getRandomColor();
                    for (ShapeItem item : shapes) {
                        if (item.getShape().contains(e.getPoint())) {
                            item.setColor(color);
                        }
                    }
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            for (ShapeItem item : shapes) {
                g2.setColor(item.getColor());
                g2.fill(item.getShape());
            }

            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        private Color getRandomColor() {
            return new Color(rand.nextFloat(), rand.nextFloat(),
                rand.nextFloat());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DemoShapes();
            }
        });
    }
}