public class Sphere {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }


    public double getVolume() {
        return (4.0 / 3) * Math.PI * this.radius * this.radius * this.radius;
    }
}