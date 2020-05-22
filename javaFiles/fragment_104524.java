public Color getPixel(int x, int y) {
    if (x > size.x || y > size.y) {
        return null;
    }

    int index = (x + y * size.x) * 4;

    int r = pixels[index] & 0xFF;
    int g = pixels[index + 1] & 0xFF;
    int b = pixels[index + 2] & 0xFF;
    int a = pixels[index + 3] & 0xFF;

    return new Color(r, g, b, a);
}