public abstract class AbstractEntity implements Entity {

    private final Point location = new Point(0, 0);

    @Override
    public Point getLocation() {
        return new Point(location);
    }

    @Override
    public void setLocation(Point p) {
        location.setLocation(p);
    }

}

public class Player extends AbstractEntity {

    public Player(Rectangle bounds) {
        int x = bounds.x + ((bounds.width - getSize().width) / 2);
        int y = bounds.y + (bounds.height - getSize().height);
        setLocation(new Point(x, y));
    }

    @Override
    public Dimension getSize() {
        return new Dimension(40, 17);
    }

    @Override
    public void paint(Graphics2D g2d) {
        Point p = getLocation();
        Dimension size = getSize();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(p.x, p.y + 7, size.width, 10);
        g2d.fillRect(p.x + 18, p.y, 4, 7);
    }

}

public class Bullet extends AbstractEntity {

    @Override
    public void paint(Graphics2D g2d) {
        Rectangle bullet = new Rectangle(getLocation(), getSize());
        g2d.setColor(Color.RED);
        g2d.fill(bullet);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(4, 8);
    }

}