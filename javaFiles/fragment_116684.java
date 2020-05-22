public void calculateCirclePoints(){
    double radius = getDistance();
    double radians;
    double x;
    double y;
    Point currentPoint;

    for (int degrees = 0; degrees <= 360; degrees += 1){
        radians = Math.toRadians(degrees);
        x = endPoint.getX() + (radius * Math.cos(radians));
        y = endPoint.getY() + (radius * Math.sin(radians));
        currentPoint = new Point(x, y);
        points.add(currentPoint);
    }
}