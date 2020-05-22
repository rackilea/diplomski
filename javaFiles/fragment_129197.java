public static Point2D transform(Node coordinatesNode, Node ancestor, double x, double y) {
    Point2D coordinates = new Point2D(x, y);
    while (coordinatesNode != ancestor) {
        coordinates = coordinatesNode.localToParent(coordinates);
        coordinatesNode = coordinatesNode.getParent();
    }
    return coordinates;
}