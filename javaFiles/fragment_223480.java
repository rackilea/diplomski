BufferedImage image = ImageIO.read ( url );
BufferedImage convertedImage = null;
GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment ();
GraphicsDevice gd = ge.getDefaultScreenDevice ();
GraphicsConfiguration gc = gd.getDefaultConfiguration ();
convertedImage = gc.createCompatibleImage (image.getWidth (), 
                                           image.getHeight (), 
                                           image.getTransparency () );
Graphics2D g2d = convertedImage.createGraphics ();
g2d.drawImage ( image, 0, 0, image.getWidth (), image.getHeight (), null );
g2d.dispose()