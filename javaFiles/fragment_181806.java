final int height = result.length;
final int width = result[0].length;
final BufferedImage image =
    new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
for (int y = 0; y < height; ++y) {
    for (int x = 0; x < width; ++x) {
        bufferedImage.setRGB(x, y, result[y][x]);
    }
}