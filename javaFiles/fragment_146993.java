function dist(Curve curve, Vector p) {
    d = dist(p, curve.vertices.get(0));
    for (int i = 1, n = curve.vertices.size(); i < n; ++i) {
        Vector p1 = curve.vertices.get(i-1);
        Vector p2 = curve.vertices.get(i);
        d = min(d, dist(new Segment(p1, p2), p));
    }
    return d;
}