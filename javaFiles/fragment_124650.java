@Override
public void paint(Graphics originalGraphics) {
  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
  GraphicsConfiguration c = e.getDefaultScreenDevice().getDefaultConfiguration();
  //create own image to paint to
  BufferedImage image = c.createCompatibleImage(getWidth(), getHeight());
  Graphics2D reusableGraphics = image.createGraphics();
  //let it paint into our graphics
  super.paint(reusableGraphics);
  // draw image on this component
  originalGraphics.drawImage(image, 0, 0, null);
  // draw image on other component
  otherComponent.setMirrorImage(image);
}