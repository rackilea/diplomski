public void update(Graphics g) {

    Graphics2D g2 = (Graphics2D) g;
    Dimension dim = getSize();
    int w = (int) dim.getWidth();
    int h = (int) dim.getHeight();

    // Create the buffer
    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D ig2 = image.createGraphics();

    // Paint everythign on the buffer
    // Clears the rectangle that was previously drawn
    ig2.setPaint(Color.BLACK);
    ig2.fillRect(0, 0, w, h);

    drawLines(ig2, w, h);

    // Paint the buffer
    g2.drawImage(image, 0, 0, null);
}