public class Circle {
    private double radius;
    private double area;

    public Circle(double diameter) {
        this.radius = diameter / 2;
        this.area = Math. PI * radius * radius;
    }

    public double getArea() {
        return area;
    }

    public double getDiameter() {
        return this.radius / 2;
    }

    public void setDiameter(double diameter) {
        this.radius = diameter / 2;
        // the area must also be changed, else the invariants are broken.
        this.area = Math. PI * radius * radius;
    }
}