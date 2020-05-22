// Paint the JPanel to a BufferedImage.
Dimension size = jpanel.getSize();
int imageType = BufferedImage.TYPE_INT_ARGB;
BufferedImage image = BufferedImage(size.width, size.height, imageType);
Graphics2D g2d = image.createGraphics();
jpanel.paint(g2);

// Now iterate the image in row-major order to test its pixel colors.
for (int y=0; y<size.height; y++) {
  for (int x=0; ix<size.width; x++) {
    int pixel = image.getRGB(x, y);
    if (pixel == 0xFF000000) {
      // Black (assuming no transparency).
    } else if (pixel == 0xFFFFFFFF) {
      // White (assuming no transparency).
    } else {
      // Some other color...
    }
  }
}