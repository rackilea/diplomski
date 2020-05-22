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