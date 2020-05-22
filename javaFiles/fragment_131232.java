private void doDrawing(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    AffineTransform originalTransform = g2.getTransform();
    g2.scale(getWidth() / (double) WIDTH, getHeight() / (double) HEIGHT);

    // Do all drawing here

    g2.setTransform(originalTransform);
}