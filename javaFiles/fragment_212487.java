public static void makeGray(BufferedImage img)
{
    for (int x = 0; x < img.getWidth(); x++) {
        for (int y = 0; y < img.getHeight(); y++) {
            int rgb = img.getRGB(x, y);
            int r = (rgb >> 16) & 0xFF;
            int g = (rgb >> 8) & 0xFF;
            int b = (rgb & 0xFF);

            int grayLevel = (r + g + b) / 3;
            int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
            img.setRGB(x, y, gray);
        }
    }
}