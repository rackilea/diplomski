private int interpolate(int x, int y, int v1, int v2, int v3) {
    // these are my triangle corners

    Vector p1v = new Vector(p1.x, p1.y);
    Vector p2v = new Vector(p2.x, p2.y);
    Vector p3v = new Vector(p3.x, p3.y);

    // current point
    Vector f = new Vector(x, y);

    // calculate weighted average

    double a1 = triangleArea(f, p2v, p3v);
    double a2 = triangleArea(f, p1v, p3v);
    double a3 = triangleArea(f, p1v, p2v);

    return (int) ((a1 * v1 + a2 * v2 + a3 * v3) / (a1 + a2 + a3));

}