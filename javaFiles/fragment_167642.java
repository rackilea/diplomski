public abstract class AbstractPiece implements Piece {

    private Rectangle bounds;
    private Color color;

    @Override
    public void setLocation(Point point) {
        bounds.setLocation(point);
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

public class Square extends AbstractPiece {

    public Square(Point location, int size, Color color) {
        Rectangle bounds = new Rectangle();
        bounds.setLocation(location);
        bounds.setSize(size, size);
        setBounds(bounds);
        setColor(color);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.setColor(getColor());
        g2d.fill(getBounds());
        g2d.setColor(Color.GRAY);
        Rectangle bounds = getBounds();
        g2d.drawLine(bounds.x + (bounds.width / 2), bounds.y, bounds.x + (bounds.width / 2), bounds.y + bounds.height);
        g2d.drawLine(bounds.x, bounds.y + (bounds.height / 2), bounds.x + bounds.width, bounds.y + (bounds.height / 2));
    }

}