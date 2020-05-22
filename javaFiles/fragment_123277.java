public class Vector {
    private double i, j; // the component values

    public Vector(double v0, double theta) {
        i = v0 * Math.cos(theta);
        j = v0 * Math.sin(theta);
    }

    public double iComponent() {
        return i;
    }

    public double jComponent() {
        return j;
    }
}