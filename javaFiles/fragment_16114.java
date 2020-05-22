private Icon createIcon(Color color) {
  BufferedImage img = new BufferedImage(IMG_W, IMG_H,
        BufferedImage.TYPE_INT_ARGB);
  Graphics g = img.getGraphics();
  g.setColor(color);
  g.fillRect(0, 0, IMG_W, IMG_H);
  g.dispose();
  return new ImageIcon(img);
}