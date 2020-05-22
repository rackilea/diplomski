import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @see https://stackoverflow.com/q/44136040/230513
 */
public class BufferedImageTest extends Application {

    private static final int PANEL_WIDTH = 600, PANEL_HEIGHT = 600;
    private static final int TRI_WIDTH = 500, TRI_HEIGHT = 500;
    private static final int SIDE_GAP = (PANEL_WIDTH - TRI_WIDTH) / 2;
    private static final int TOP_GAP = (PANEL_HEIGHT - TRI_HEIGHT) / 2;
    private final int numberOfLevels = 13;
    private int countTriangles;

    @Override
    public void start(Stage stage) {
        stage.setTitle("BufferedImageTest");
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        root.getChildren().add(new ImageView(createImage()));
        stage.setScene(scene);
        stage.show();
    }

    private Image createImage() {
        BufferedImage bi = new BufferedImage(
            PANEL_WIDTH, PANEL_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.setPaint(Color.white);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        Point top = new Point(PANEL_WIDTH / 2, TOP_GAP);
        Point left = new Point(SIDE_GAP, TOP_GAP + TRI_HEIGHT);
        Point right = new Point(SIDE_GAP + TRI_WIDTH, TOP_GAP + TRI_HEIGHT);
        g.setColor(Color.red);
        long startTime = System.currentTimeMillis();
        drawTriangle(g, numberOfLevels, top, left, right);
        g.setPaint(Color.black);
        g.drawString("Number of triangles: " + countTriangles, 15, 15);
        g.drawString("Time : " + (System.currentTimeMillis() - startTime) + " ms", 15, 35);
        g.drawString("Levels: " + numberOfLevels, 15, 50);
        WritableImage image = SwingFXUtils.toFXImage(bi, null);
        g.dispose();
        return image;
    }

    private void drawTriangle(Graphics2D g, int levels, Point top, Point left, Point right) {
        if (levels < 0) {
            return;
        }
        countTriangles++;
        Polygon tri = new Polygon();
        tri.addPoint(top.x, top.y);
        tri.addPoint(left.x, left.y);
        tri.addPoint(right.x, right.y);
        g.drawPolygon(tri);

        // Get the midpoint on each edge in the triangle
        Point p12 = midpoint(top, left);
        Point p23 = midpoint(left, right);
        Point p31 = midpoint(right, top);

        // recurse on 3 triangular areas
        drawTriangle(g, levels - 1, top, p12, p31);
        drawTriangle(g, levels - 1, p12, left, p23);
        drawTriangle(g, levels - 1, p31, p23, right);
    }

    private Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }

}