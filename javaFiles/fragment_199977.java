BufferedImage transposedHBlur(BufferedImage im) {
    int height = im.getHeight();
    int width = im.getWidth();
    // result is transposed, so the width/height are swapped
    BufferedImage temp =  new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
    float[] k = new float[7] { 0.00598, 0.060626, 0.241843, 0.383103, 0.241843, 0.060626, 0.00598 };
    // horizontal blur, transpose result
    for (int y = 0; y < height; y++) {
        for (int x = 3; x < width - 3; x++) {
            float r = 0, g = 0, b = 0;
            for (int i = 0; i < 7; i++) {
                int pixel = im.getRGB(x + i - 3, y);
                b += (pixel & 0xFF) * k[i];
                g += ((pixel >> 8) & 0xFF) * k[i];
                r += ((pixel >> 16) & 0xFF) * k[i];
            }
            int p = (int)b + ((int)g << 8) + ((int)r << 16);
            // transpose result!
            temp.setRGB(y, x, p);
        }
    }
    return temp;
}