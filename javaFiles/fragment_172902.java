public class MovableObject {

    private Point point;
    private Point vector;

    public MovableObject(Point point, Point vector) {
        this.point = point;
        this.vector = vector;
    }

    public void paint(Graphics2D g2d) {
        g2d.fillRect(point.x - SIZE, point.y - SIZE, SIZE * 2, SIZE * 2);
    }

    public void move(Dimension bounds) {
        point.x += vector.x;
        point.y += vector.y;
        if (point.x - SIZE <= 0) {
            vector.x *= -1;
            point.x = 0;
        } else if (point.x + SIZE > bounds.width) {
            vector.x *= -1;
            point.x = bounds.width - SIZE;
        }
        if (point.y - SIZE <= 0) {
            vector.y *= -1;
            point.y = 0;
        } else if (point.y + SIZE >= bounds.width) {
            vector.y *= -1;
            point.y = bounds.height - SIZE;
        }
    }

}