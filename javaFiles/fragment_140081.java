public class Point2{
    private int a;
    private int b;
    private Point startingPoint;

    public Point2(int a, int b, Point p){
        this.a = a;
        this.b = b;
        startingPoint = p;
    }

    // Computes the distance from starting point to this
    public double measureDistance(){//it takes no parameter.
        return startingPoint.distanceTo(a, b);
    }

    /*
    if you can't edit distanceTo() it gets a little verbose but you must create a
 Point with Point2 coordinates - remember this example when you will study Inheritance

    public double measureDistance() {
        Point endingPoint = new Point(a, b);
        return startingPoint.distanceTo(endingPoint);
    }
    */

}