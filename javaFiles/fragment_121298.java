@Override
public void mouseDragged(MouseEvent e) {
    if (resizing && clickPoint != null) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        int xDelta = mouseX - clickPoint.x;
        int yDelta = mouseY - clickPoint.y;

        int delta = Math.max(xDelta, yDelta);

        Rectangle bounds = shapes.get(currentIndex).getBounds();
        int shapeX = bounds.x;
        int shapeY = bounds.y;

        int shapeWidth = originalBounds.width + delta;
        int shapeHeight = originalBounds.height + delta;

        if (shapeWidth < 0) {
            shapeWidth *= -1;
            shapeX = originalBounds.x - shapeWidth;
        }
        if (shapeHeight < 0) {
            shapeHeight *= -1;
            shapeY = originalBounds.y - shapeHeight;
        }

        System.out.printf("%d %dx%dx%dx%d%n", delta, shapeX, shapeY, shapeWidth, shapeHeight);

        shapes.get(currentIndex).reset();
        shapes.get(currentIndex).append(
                        new Ellipse2D.Double(shapeX, shapeY, shapeWidth, shapeHeight), true);
        repaint();
    }
}