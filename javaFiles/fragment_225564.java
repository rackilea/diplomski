public class Circle {
    private double radius;

    public Circle(double diameter) {
        this.radius = diameter / 2;
    }

    public double getArea() {
        return Math. PI * radius * radius;
    }

    public double getDiameter() {
        return this.radius * 2;
    }
}