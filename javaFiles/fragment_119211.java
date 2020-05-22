List<Point> jarvis(List<Point> points) {
    List<Point> hull = new ArrayList<>();
    Point q = Collections.min(points, Comparator.comparing(p -> p.x));
    do {
        hull.add(q);

        Point leftMost = null;
        for (Point p : points) {
            if (p == q) continue;
            if (leftMost == null || left(p,q,leftMost)) {
                leftMost = p;
            }
        }

        q = leftMost;
    } while (q != hull.get(0));
    return null;
}