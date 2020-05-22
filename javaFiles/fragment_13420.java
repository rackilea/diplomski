public Point centroid()  {
    double centroidX = 0, centroidY = 0;

        for(Point knot : knots) {
            centroidX += knot.getX();
            centroidY += knot.getY();
        }
    return new Point(centroidX / knots.size(), centroidY / knots.size());
}