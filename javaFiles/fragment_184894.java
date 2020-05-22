public static double varianceRed(BufferedImage image) {
    double mean = meanValueRed(image);
    double sumOfDiff = 0.0;

    for (int y = 0; y < image.getHeight(); ++y) {
        for (int x = 0; x < image.getWidth(); ++x) {
             Color r = new Color(image.getRGB(x, y)); // Moved inside loop, with proper indexes
             double colour = r.getRed() - mean;
             sumOfDiff += Math.pow(colour, 2); 
         }
    }

    return sumOfDiff / ((image.getWidth() * image.getHeight()) - 1);
}