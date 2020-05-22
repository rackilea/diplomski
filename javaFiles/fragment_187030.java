import java.awt.Graphics;

public class Circle extends Shape {

    public Circle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void drawCircle(Graphics g) {
        g.setColor(super.colour);
        // instead of writing values here, we get them from width and height fields
        g.fillOval(x, y, (int) getWidth(), (int) getHeight());
    }

    public void collision() {
        for (Circle CircleShape : Main.circleList) {
            System.out.println(CircleShape);
            System.out.println(CircleShape.getLocation().x);

            if (this.intersects(CircleShape)) {
                System.out.println("collision detected");
            } else {
                System.out.println("no collision detected");
            }

        }
    }
}