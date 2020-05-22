public Collection<Point> scaleShape(float scale, Collection<Point> shape) {
    Point centroid = getCentroid();
    Collection<Point> scaledShape = new ArrayList<>(shape.size());

    for (Point point : shape) {
        Point diff = new Point(point.x() - centroid.x(), point.y() - centroid.y());
        Point scaledPoint = new Point(
            (int) (centroid.x() + scale * diff.x()),
            (int) (centroid.y() + scale * diff.y()));

        scaledShape.add(scaledPoint);
    }

    return scaledShape;
}