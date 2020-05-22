Component applet = ...;    // the applet

  Dimension size = applet.getSize();
  BufferedImage offScreenImage = (BufferedImage) applet.createImage(size.width, size.height);
  Graphics2D g2 = offScreenImg.createGraphics();
  g2.setBackground(applet.getBackground());

  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

  g2.clearRect(0, 0, size.width, size.height);

  applet.paint(g2);

  // now you can use BufferedImage as before