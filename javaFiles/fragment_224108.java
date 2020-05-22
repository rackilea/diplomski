public abstract class Shape {

    public abstract double getVolume();
    public abstract double getHeight();
    public abstract double getLength();
    public abstract double getWidth();
    public abstract Color getColor();
}

public class Line extends Shape {

    public double length;
    public Color color;

    // Kind of forced to have a volume...
    public double getVolume() {
        return 0;
    }

    /// ...and a height...
    public double getHeight() {
        return 0;
    }

    // ...and a width...
    public double getWidth() {
        return 0;
    }

    public double getLength() {
        return length;
    }

    public Color getColor() {
        return color;
    }
}