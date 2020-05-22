@Override
public void paint(Graphics g) {
  if (mirroredImage == null) {
    super.paintAll(g);
  } else {
    g.drawImage(mirroredImage, 0, 0, getWidth() * 3 / 4, getHeight() * 3 / 4, null);
  }
}
public void setMirrorImage(BufferedImage mirroredImage) {
  this.mirroredImage = mirroredImage;
  repaint();
}