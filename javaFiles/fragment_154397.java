public BufferedImage prependImage(BufferedImage image1, BufferedImage image2) {
    Dimension d1 = new Dimension(image1.getWidth(null),
            image1.getHeight(null));
    Dimension d2 = new Dimension(image2.getWidth(null),
            image2.getHeight(null));
    Dimension dt = new Dimension(d1.width, d1.height + d2.height);

    BufferedImage image = new BufferedImage(dt.width, dt.height,
            BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();

    int x = 0;
    int y = 0;
    g.drawImage(image1, x, y, d1.width, d1.height, null);
    y += d1.height;
    g.drawImage(image2, x, y, d2.width, d2.height, null);
    g.dispose();

    return image;
}