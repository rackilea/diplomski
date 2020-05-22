private Path2D.Double transform(Rectangle2D.Double rect) {

    AffineTransform transform = new AffineTransform();
    double angle = Math.toRadians(theta);
    transform.rotate(angle, rect.x + rect.width / 2, rect.y + rect.height / 2);

    return new Path2D.Double(rect, transform);
}