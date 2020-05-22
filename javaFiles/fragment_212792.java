public static enum Direction {
    LEFT,
    RIGHT,
    SPACE
}

public interface Entity {
    public void paint(Graphics2D g2d);
    public Point getLocation();
    public void setLocation(Point p);
    public Dimension getSize();
}

public interface GameModel {
    public Entity[] getEntities();
    public void update(Rectangle bounds, Set<Direction> keys);
}

public interface GameController {
    public Entity[] getEntities();
    public void setDirection(Direction direction, boolean pressed);
    public void start();
}

public interface GameView {
    public void setController(GameController controller);
    public GameController getController();
    public Rectangle getViewBounds();
    public void repaint();
}