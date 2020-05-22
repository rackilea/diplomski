import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.Random;
import java.awt.Polygon;
import java.awt.Shape;


public class GraphicsTest extends JFrame {

    private List<ColoredShape> shapes;
    private static final int NUM_SHAPES = 50;
    private static final int NUM_POINTS_PER_SHAPE = 5;

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private Random randomGenerator;

    public GraphicsTest(String title) {
        super(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);


        randomGenerator = new Random();

        initShapes();
    }

    private void initShapes() {
        shapes = new ArrayList<ColoredShape>(NUM_SHAPES);
        for (int i = 0; i < NUM_SHAPES; i++) {
            Point[] points = getRandomPoints();
            Color color = getRandomColor();

            shapes.add(i, new ColoredShape(points, color));
        }

    }


    private Point[] getRandomPoints() {
        Point[] points = new Point[NUM_POINTS_PER_SHAPE];
        for (int i = 0; i < points.length; i++) {
            int x = randomGenerator.nextInt(WIDTH);
            int y = randomGenerator.nextInt(HEIGHT);
            points[i] = new Point(x, y);
        }
        return points;
    }

    /**
    * @return a Color with random values for alpha, red, green, and blue values
    */
    private Color getRandomColor() {
        float alpha = randomGenerator.nextFloat();
        float red = randomGenerator.nextFloat();
        float green = randomGenerator.nextFloat();
        float blue = randomGenerator.nextFloat();

        return new Color(red, green, blue, alpha);
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (ColoredShape shape : shapes) {
            g2.setColor(shape.getColor());
            g2.fill(shape.getOutline());
        }
    }


    public static void main(String[] args) {
        GraphicsTest b = new GraphicsTest("Testing polygons");
    }


    private class ColoredShape {

        private Polygon outline;
        private Color color;

        public ColoredShape(Point[] points, Color color) {
            this.color = color;
            // Would be better to separate out into xpoints, ypoints, npoints
            // but I'm lazy
            outline = new Polygon();
            for (Point p : points) {
                outline.addPoint((int) p.getX(), (int) p.getY());
            }
        }

        public Color getColor() {
            return color;
        }

        public Shape getOutline() { return outline; }

    }


}