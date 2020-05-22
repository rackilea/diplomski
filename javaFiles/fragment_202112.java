private int colorToInt(Color c) {
    int r = (int) Math.round(c.getRed() * 255);
    int g = (int) Math.round(c.getGreen() * 255);
    int b = (int) Math.round(c.getBlue() * 255);
    return (r << 16) | (g << 8) | b;
}