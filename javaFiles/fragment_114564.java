public boolean overlaps(Disk other) {
    double xDistance = getX() - other.getX();
    double yDistance = getY() - other.getY();

    double sumOfRadii = getRadius() + other.getRadius();
    double distanceSquared = xDistance * xDistance + yDistance * yDistance;

    boolean isOverlapping = distanceSquared  < sumOfRadii * sumOfRadii;
    return isOverlapping;
}