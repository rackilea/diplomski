public class CircleWithPrivateDataFields {
    private double radius;

    public CircleWithPrivateDataFields(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("The area of the circle of radius %.2f is %.2f", radius, getArea());
    }

    public static void main(String[] args) {
        CircleWithPrivateDataFields circle = new CircleWithPrivateDataFields(5);
        System.out.println(circle);
    }

}