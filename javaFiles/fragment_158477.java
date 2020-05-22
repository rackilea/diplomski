// Point.java
public class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // ...
}

// Rectangle.java
public class Rectangle {

    private final Point lowLeft;
    private final Point upRight;

    public Rectangle(final Point lowLeft, final Point upRight) {
        this.lowLeft = lowLeft;
        this.upRight = upRight;
    }

    public Rectangle(final Point upRight) {
        this(new Point(0, 0), upRight);
    }

    public Rectangle() {
        this(new Point(1, 1));
    }
}