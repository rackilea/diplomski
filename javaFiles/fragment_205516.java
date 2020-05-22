BufferedImage overlay(BufferedImage img1, BufferedImage img2) {
    final BufferedImage combined = new BufferedImage(img1.getWidth(),
                                                     img1.getHeight(),
                                                     BufferedImage.TYPE_INT_ARGB);
    final Graphics g = combined.getGraphics();
    g.drawImage(img1, 0, 0, null);
    g.drawImage(img2, 0, 0, null);
    return combined;
}