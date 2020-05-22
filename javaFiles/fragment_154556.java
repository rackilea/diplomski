if (bufferedImage.getColorModel() instanceof ComponentColorModel) {
    ComponentColorModel colorModel = (ComponentColorModel)bufferedImage.getColorModel();

    //ASSUMES: 3 BYTE BGR IMAGE TYPE

    PaletteData palette = new PaletteData(0x0000FF, 0x00FF00,0xFF0000);
    ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);

    //This is valid because we are using a 3-byte Data model with no transparent pixels
    data.transparentPixel = -1;

    WritableRaster raster = bufferedImage.getRaster();
    int[] pixelArray = new int[3];
    for (int y = 0; y < data.height; y++) {
        for (int x = 0; x < data.width; x++) {
            raster.getPixel(x, y, pixelArray);
            int pixel = palette.getPixel(new RGB(pixelArray[0], pixelArray[1], pixelArray[2]));
            data.setPixel(x, y, pixel);
        }
    }
    return data;