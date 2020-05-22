public static void calculateSkintoneGPU() throws IOException {
    BufferedImage img = ImageIO.read(SkinTone.class.getClassLoader().getResource("images.jpg"));
    if (img == null || img.getData() == null)
        return;

    int width = img.getWidth(null);
    int height = img.getHeight(null);
    int[] pixels = new int[width * height];
    PixelGrabber pg = new PixelGrabber(img, 0, 0, width, height, pixels, 0, width);
    try {
        pg.grabPixels();
    } catch (InterruptedException e){};

    int totalPixels = width * height;

    CUfunction kernelFunction = initlize();

    int output[] = execute(kernelFunction, pixels, width, height);
    // Flushing memory
    img.flush();
    img = null;

    long skintoneThreshold = Math.round(output[0] / (double) totalPixels * 100.0);

    System.err.println("Skintone Using GPU: " + output[0]);
    System.err.println("Total Pixel Of GPU: " + totalPixels);
    System.err.println("SKinTone Percentage Using GPU: " + skintoneThreshold + "%");
}