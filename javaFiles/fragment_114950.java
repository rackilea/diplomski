GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gs = ge.getDefaultScreenDevice();
GraphicsConfiguration gc = gs.getDefaultConfiguration();

// Create an image that does not support transparency
BufferedImage bimage = gc.createCompatibleImage(100, 100, Transparency.OPAQUE);