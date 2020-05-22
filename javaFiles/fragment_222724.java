import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class RectangleModel {

    private List<Rectangle> rectangles;

    public RectangleModel() {
        this.rectangles = new ArrayList<Rectangle>();
    }

    public void addRectangle(int x, int y, int width, int height) {
        this.rectangles.add(new Rectangle(x, y, width, height));
    }

    public void addRectangle(Rectangle rectangle) {
        this.rectangles.add(rectangle);
    }

    public void draw(Graphics g) {
        for (Rectangle rectangle : rectangles) {
            g.drawRect(rectangle.x, rectangle.y, rectangle.width,
                    rectangle.height);
        }
    }

}