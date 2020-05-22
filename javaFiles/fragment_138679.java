import java.awt.Graphics;

public class RectangleShape extends Shape {
    public RectangleShape(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public RectangleShape() {
        super();
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}