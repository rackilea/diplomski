public static Image getImageFromArray(int[] pixels, int width, int height) throws IOException {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster(); //faster - no copy
    raster.setDataElements(0, 0, width, height, pixels); //instead of setPixels
    File output = new File("C:\\out.png");
    ImageIO.write(image, "png", output);
    System.out.print("written");
    return image;
}