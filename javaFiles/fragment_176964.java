public class Point {

//Initializes the coordinates for a point on a graph with the values of x and y
private double x;
private double y;

//Defualt Constructor
public Point() {
    x = 0;
    y = 0;
}

//Point Constructor
public Point(double x, double y) {
    this.x = x;
    this.y = y;
}

//Returns the x value
public double getX() {
    return x;
}

//Changes the x value
public void setX(double x) {
    this.x = x;
}

//Returns the y value
public double getY() {
    return y;
}

//Changes the y value
public void setY(double y) {
    this.y = y;
}

//Calculates the distance between the class's point coordinates and another set of point coordinates
public double distance(double x0, double y0) {
    double distance = (Math.sqrt(((x0 - x) * 2.0) + ((y0 - y) * 2.0)));
    return distance;
}

//Calculates the distance between the class's point and another Point class's location
public double distance(Point p) {
    double distance = (Math.sqrt(((p.getX() - x) * (p.getX() - x)) + ((p.getY() - y) * (p.getY() - y))));
    return distance;
}

//Calculates the distance between a Point class's location and another Point class's location
public static double distance(Point p1, Point p2) {
    double distance = (Math.sqrt((Math.pow((p2.getX() - p1.getX()), 2.0) + (Math.pow((p2.getY() - p1.getY()), 2.0)))));
    return distance;