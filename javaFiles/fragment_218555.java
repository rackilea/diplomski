private static Pixmap getScreenshot(int x, int y, int width, int height) {

    final Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(x, y, width, height);

    ByteBuffer pixels = pixmap.getPixels();
    for(int i = 4; i < pixels.limit(); i += 4) {
        pixels.put(i - 1, (byte) 255);
    }

    int numBytes = width * height * 4;
    byte[] lines = new byte[numBytes];
    int numBytesPerLine = width * 4;
    for(int i = 0; i < height; i++) {
        pixels.position((height - i - 1) * numBytesPerLine);
        pixels.get(lines, i * numBytesPerLine, numBytesPerLine);
    }
    pixels.clear();
    pixels.put(lines);
    pixels.clear();

    return pixmap;
}