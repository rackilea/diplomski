double delta = 360.0 / (double) nlines;
Graphics2D gCopy = (Graphics2D) g.create();
AffineTransform at = AffineTransform.getRotateInstance(
        Math.toRadians(delta),
        centerPoint.x,
        centerPoint.x);
for (int h = 0; h < nlines; h++) {
    for (DoilyPoint j : points) {
        gCopy.fillOval(j.getX(), j.getY(), j.getSize(), j.getSize());
    }
    gCopy.transform(at);
}
gCopy.dispose();