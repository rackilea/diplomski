public static BufferedImage rasterToAlpha(BufferedImage sourceImage, Color origColor) {

    BufferedImage targetImage = new BufferedImage(sourceImage.getWidth(),
                                                  sourceImage.getHeight(),
                                                  BufferedImage.TYPE_4BYTE_ABGR);
    WritableRaster targetRaster = targetImage.getRaster();
    WritableRaster sourceRaster = sourceImage.getRaster();

    for (int row = 0; row < sourceImage.getHeight(); row++) {

        int[] rgba = new int[4 * sourceImage.getWidth()];
        int[] rgb = new int[3 * sourceImage.getWidth()];

        // Get the next row of pixels
        sourceRaster.getPixels(0, row, sourceImage.getWidth(), 1, rgb);

        for (int i = 0, j = 0; i < rgb.length; i += 3, j += 4) {
            if (origColor.equals(new Color(rgb[i], rgb[i + 1], rgb[i + 2]))) {
                // If it's the same make it transparent
                rgba[j] = 0;
                rgba[j + 1] = 0;
                rgba[j + 2] = 0;
                rgba[j + 3] = 0;
            } else {
                rgba[j] = rgb[i];
                rgba[j + 1] = rgb[i + 1];
                rgba[j + 2] = rgb[i + 2];
                // Make it opaque
                rgba[j + 3] = 255;
            }
        }
        // Write the line
        targetRaster.setPixels(0, row, sourceImage.getWidth(), 1, rgba);
    }
    return targetImage;
}