public class Foo {
    private double A;
    private double B;
    ...
    private double K;

    public Foo(double... coordinates) {
        if (coordinates == null || coordinates.length != 11) {
            throw new IllegalArgumentException("Unexpected size of coordinates");
        }
        this.A = coordinates[0];
        this.B = coordinates[1];
        ...
        this.K = coordinates[10];
    }
    ...
}