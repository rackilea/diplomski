public class Rectangle {

    private double lowLeftX;
    private double lowLeftY;
    private double upRightX;
    private double upRightY;

    public Rectangle(double lowLeftX, double lowLeftY, double upRightX, double upRightY) {
        this.lowLeftX = lowLeftX;
        this.lowLeftY = lowLeftY;
        this.upRightX = upRightX;
        this.upRightY = upRightY;
    }

    public Rectangle(double upRightX, double upRightY) {
        this(0, 0, upRightX, upRightY); // = Rectangle(0, 0, upRightX, upRightY)
    }

    public Rectangle() {
        this(0, 0, 1, 1); // = Rectangle(0, 0, 1, 1), or Rectangle(1, 1)
    }

    // ...
}