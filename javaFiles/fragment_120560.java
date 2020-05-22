public static Image getImageFromArray(int[] pixels, int w, int h) {
    BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = (WritableRaster) image.getData();
    raster.setPixels(0,0,w,h,pixels);
    image.setData(raster); //<-- add this line
    return image;
}