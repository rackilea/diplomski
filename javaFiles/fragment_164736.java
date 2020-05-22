private Point getNearestPoint(List<Point> pointList, Point target) {
    Point nearest = null;
    double shortestDistance = Double.MAX_VALUE;
    double distance = 0;

    for(Point p : pointList) {
        distance = getDistance(p, target);
        if(distance < shortestDistance) {
            shortestDistance = distance;
            nearest = p;
        }
    }

    return nearest;
}

private double getDistance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
}