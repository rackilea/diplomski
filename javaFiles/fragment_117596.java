// The example function you provided.
public double f(double x, double y) {
    return x + y * y;
}

/**
 * Finds the volume under the surface described by the function f(x, y) for a <= x <= b, c <= y <= d.
 * Using xSegs number of segments across the x axis and ySegs number of segments across the y axis. 
 * @param a The lower bound of x.
 * @param b The upper bound of x.
 * @param c The lower bound of y.
 * @param d The upper bound of y.
 * @param xSegs The number of segments in the x axis.
 * @param ySegs The number of segments in the y axis.
 * @return The volume under f(x, y).
 */
public double trapezoidRule(double a, double b, double c, double d, int xSegs, int ySegs) {
    double xSegSize = (b - a) / xSegs; // length of an x segment.
    double ySegSize = (d - c) / ySegs; // length of a y segment.
    double volume = 0; // volume under the surface.

    for (int i = 0; i < xSegs; i++) {
        for (int j = 0; j < ySegs; j++) {
            double height = f(a + (xSegSize * i), c + (ySegSize * j));
            height += f(a + (xSegSize * (i + 1)), c + (ySegSize * j));
            height += f(a + (xSegSize * (i + 1)), c + (ySegSize * (j + 1)));
            height += f(a + (xSegSize * i), c + (ySegSize * (j + 1)));
            height /= 4;

            // height is the average value of the corners of the current segment.
            // We can use the average value since a box of this height has the same volume as the original segment shape.

            // Add the volume of the box to the volume.
            volume += xSegSize * ySegSize * height;
        }
    }

    return volume;
}