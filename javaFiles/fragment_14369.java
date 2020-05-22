public class Circle {
    public Circle() {
        this(1.0, "red");
    }


    public Circle(double r) {
        this(r, "Blue");
    }

    public Circle(double r, String c) {
        radius = r;
        color = c;
    }
    ...
}