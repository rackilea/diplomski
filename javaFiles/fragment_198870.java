double scale = 0.5; // make it half as wide and high as big image
  int smallImageWidth = (int) (bigImage.getWidth() * scale);
  int smallImageHeight = (int) (bigImage.getHeight() * scale);

  BufferedImage smallImage = new BufferedImage(smallImageWidth, smallImageHeight, BufferedImage.TYPE_INT_ARGB);
  // get a Graphics object from this image
  Graphics g = smallImage.getGraphics();

  // draw in the large image, scaling it
  g.drawImage(bigImage, 0, 0, smallImageWidth, smallImageHeight, null);

  // get rid of the Graphics object to save resources
  g.dispose(); // never do this with Graphics objects given you by the JVM