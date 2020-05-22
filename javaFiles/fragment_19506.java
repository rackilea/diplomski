public BufferedImage createImage(JPanel panel) {
  BufferedImage originalImage = new BufferedImage(
        panel.getHeight(), panel.getWidth(), 
        BufferedImage.TYPE_BYTE_INDEXED);
  Graphics2D gg = originalImage.createGraphics();
  gg.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
  gg.setRenderingHint(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
  gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
  panel.paint(gg);
  gg.dispose();
  return originalImage;
}