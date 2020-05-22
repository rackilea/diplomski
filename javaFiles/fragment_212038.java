BufferedImage image = ImageIO.read(new File("/some.jpg"));
byte[][] pixels = new byte[image.getWidth()][];

for (int x = 0; x < image.getWidth(); x++) {
    pixels[x] = new byte[image.getHeight()];

    for (int y = 0; y < image.getHeight(); y++) {
        pixels[x][y] = (byte) (image.getRGB(x, y) == 0xFFFFFFFF ? 0 : 1);
    }
}