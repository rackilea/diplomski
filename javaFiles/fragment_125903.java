public static BufferedImage crop(BufferedImage image) {
    int minY = 0, maxY = 0, minX = Integer.MAX_VALUE, maxX = 0;
    boolean isBlank, minYIsDefined = false;
    Raster raster = image.getRaster();

    for (int y = 0; y < image.getHeight(); y++) {
        isBlank = true;

        for (int x = 0; x < image.getWidth(); x++) {
            //Change condition to (raster.getSample(x, y, 3) != 0) 
            //for better performance
            if (raster.getPixel(x, y, (int[]) null)[3] != 0) {
                isBlank = false;

                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
            }
        }

        if (!isBlank) {
            if (!minYIsDefined) {
                minY = y;
                minYIsDefined = true;
            } else {
                if (y > maxY) maxY = y;
            }
        }
    }

    return image.getSubimage(minX, minY, maxX - minX + 1, maxY - minY + 1);
}