public abstract class RegularPolygon
{
    private double side;

    public RegularPolygon(double length)
    {
        side = length;
    }

    public abstract double getArea();

    // Add this...
    public double getSide() {
        return side;
    }
}