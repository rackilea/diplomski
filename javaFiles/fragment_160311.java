public class Point
{
    final public double x;
    final public double y;

    public Point(double _x, double _y)
    {
        x = _x;
        y = _y;
    }

    public double getDistanceFrom(Point p)
    {
        double distance = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
        return distance;
    }
}