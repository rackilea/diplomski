public static BufferedImage split(BufferedImage img) {
    BufferedImage pic = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics g = pic.getGraphics();

    int width = pic.getWidth() / 4;
    int height = pic.getHeight() / 4;

    Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

    // Tile the image to fill our area.
    for (int x = 0; x < pic.getWidth(); x += width) {
        for (int y = 0; y < pic.getHeight(); y += height) {
            g.drawImage(scaled, x, y, null);
        }
    }
    g.dispose();
    return pic;
}