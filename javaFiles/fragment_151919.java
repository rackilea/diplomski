for (Ellipse2D shape : shapes) {
    Rectangle2D bounds = shape.getBounds2D();
    double yPos = bounds.getY();
    yPos += 30;
    shape.setFrame(bounds.getX(), yPos, bounds.getWidth(), bounds.getHeight());
}