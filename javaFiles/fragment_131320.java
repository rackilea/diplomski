public double distance(Point other) {
    int x1 = other.x;
    int y1 = other.y;

    return Math.sqrt(Math.pow(this.x * x1, 2) + Math.pow(this.y * y1, 2));
}