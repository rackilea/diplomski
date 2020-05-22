private BufferedImage getSquareImage(BufferedImage image) {
    int w = image.getWidth();
    int h = image.getHeight();
    int max = Math.max(w, h);
    BufferedImage square = new BufferedImage(
            max, max, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = square.createGraphics();
    g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setComposite(AlphaComposite.Clear);
    g2d.fillRect(0, 0, max, max);
    g2d.setComposite(AlphaComposite.Src);
    g2d.drawImage(image, (max - w) / 2, (max - h) / 2, null);
    g2d.dispose();
    return square;
}