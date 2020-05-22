Raster raster = image.getRaster();
    int numBands = raster.getSampleModel().getNumBands();

    int width = image.getWidth();
    int height = image.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int[] pixelValue = new int[numBands];
        raster.getPixel(x, y, pixelValue);
      }
    }