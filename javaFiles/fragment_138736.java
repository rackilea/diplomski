private void drawArrowHead(Graphics2D g2) {
    double angle = Math.atan2(endY - y, endX - x);
    AffineTransform tx = g2.getTransform();
    tx.translate(endX, endY);
    tx.rotate(angle - Math.PI / 2d);
    g2.setTransform(tx);

    Polygon arrowHead = new Polygon();
    arrowHead.addPoint(0, 5);
    arrowHead.addPoint(-5, -5);
    arrowHead.addPoint(5, -5);
    g2.fill(arrowHead);
}