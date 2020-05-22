import java.awt.Graphics;
import java.util.LinkedList;

public class DrawPoints {

    public DrawPoints() {

    }

    private static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final LinkedList<Point> points = new LinkedList<Point>();

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void draw(Graphics g){
        for (Point point : points) {
            g.drawOval(point.x, point.y, 5, 5);
        }
    }

}