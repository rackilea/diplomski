function dist(Curve curve1, Curve curve2) {
    d = 0;
    for (Vector p : curve1.vertices) {
        d = max(d, dist(curve2, p));
    }
    for (Vector p : curve2.vertices) {
        d = max(d, dist(curve1, p));
    }
    return d;
}