public boolean contains(double x, double y) {
    // Normalize the coordinates compared to the ellipse
    // having a center at 0,0 and a radius of 0.5.
    double ellw = getWidth();
    if (ellw <= 0.0) {
        return false;
    }
    double normx = (x - getX()) / ellw - 0.5;
    double ellh = getHeight();
    if (ellh <= 0.0) {
        return false;
    }
    double normy = (y - getY()) / ellh - 0.5;
    return (normx * normx + normy * normy) < 0.25;
}