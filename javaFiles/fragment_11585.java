BufferedImage buffImage = reader.read(0);
WritableRaster raster = buffImage.getRaster();
int[] colorsInPixel = new int[4];
isColor = false;

// check all pixels one by one
for (int i = 0; i < reader.getWidth(0) * reader.getHeight(0); i++) {
   raster.getPixel(i % reader.getWidth(0), i / reader.getHeight(0), colorsInPixel);
   if (colorsInPixel[0] != colorsInPixel[1] || colorsInPixel[1] != colorsInPixel[2]) {
      isColor = true;
   }
}