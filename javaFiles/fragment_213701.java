private static BufferedImage createImage() {
    int width = 200;
    int height = 200;
    // Generate the source pixels for our image
    // Lets just keep it to a simple blank image for now

    byte[] pixels = new byte[width * height];
    DataBuffer dataBuffer = new DataBufferByte(pixels, width*height, 0);
    SampleModel sampleModel = new SinglePixelPackedSampleModel(
    DataBuffer.TYPE_BYTE, width, height, new int[] {(byte)0xf});
    WritableRaster raster = Raster.createWritableRaster(
    sampleModel, dataBuffer, null);
    return new BufferedImage(createColorModel(0), raster, false, null);
}

private static ColorModel createColorModel(int n) {
    // Create a simple color model with all values mapping to
    // a single shade of gray
    // nb. this could be improved by reusing the byte arrays

    byte[] r = new byte[16];
    byte[] g = new byte[16];
    byte[] b = new byte[16];
    for (int i = 0; i < r.length; i++) {
        r[i] = (byte) n;
        g[i] = (byte) n;
        b[i] = (byte) n;
    }
    return new IndexColorModel(4, 16, r, g, b);
}

private BufferedImage image = createImage();
image = new BufferedImage(createColorModel(e.getX()), image.getRaster(), false, null);