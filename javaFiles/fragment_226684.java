public static void forceFill(BufferedImage img, int rgb) {
    for(int x = 0; x < img.getWidth(); x++) {
        for(int y = 0; y < img.getHeight(); y++) {
            img.setRGB(x, y, rgb);
        }
    }
}