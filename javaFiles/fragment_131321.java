public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public double distance(Point other) {
        int x1 = other.getX();
        int y1 = other.getY();

        return Math.sqrt(Math.pow(this.x * x1, 2) + Math.pow(this.y * y1, 2));
    }
}