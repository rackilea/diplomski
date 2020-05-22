public Point2D between(Point p1, Point p2, double time) {

    double deltaX = p2.getX() - p1.getX();
    double deltaY = p2.getY() - p1.getY();

    double x = p1.getX() + time * deltaX;
    double y = p1.getY() + time * deltaY;

    return new Point2D.Double(x, y);

}