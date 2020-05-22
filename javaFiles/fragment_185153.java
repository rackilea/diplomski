private static void save(List<String> names, File file) throws IOException {
  BufferedImage image = new BufferedImage(600, 50, BufferedImage.TYPE_INT_RGB);
  Graphics2D g = image.createGraphics();
  try {
    draw(g, names);
  } finally {
    g.dispose();
  }
  ImageIO.write(image, "png", file);
}