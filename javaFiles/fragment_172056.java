public class Circle {
    private int x;
    private int y;
    private int radius;

    private Ellipse2D shape;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.shape = new Ellipse2D.Double(x, y, radius * 2, radius * 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public Rectangle getBounds() {
        return shape.getBounds();
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.ORANGE);
        g2d.fill(shape);
    }
}