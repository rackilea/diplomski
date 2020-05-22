public final class MyImmutablePoint {

    private final Point point;

    public MyImmutablePoint(Point point) {
        this.point = new Point(point);
    }

    public MyImmutablePoint() {
        this.point = new Point (0,0);
    }

    public int getX() {
        return point.x;
    }

    public int getY() {
        return point.y;
    }
}