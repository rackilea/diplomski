private static byte[] getImgBytes(BufferedImage img) throws IOException
  {
    // create a new image, with 2x the original height.
    BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight()*2, BufferedImage.TYPE_INT_RGB);

    // copy paste the pixels, but move them half the height.
    Raster sourceRaster = img.getRaster();
    WritableRaster destinationRaster = img2.getRaster();
    destinationRaster.setRect(0, img.getHeight(), sourceRaster);

    // save the new image to BMP format. 
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ImageIO.write(img2, "bmp", bos);

    // strip the first 14 bytes (contains the bitmap-file-header)
    // the next 40 bytes contains the DIB header which we still need.
    // the pixel data follows until the end of the file.
    byte[] bytes = bos.toByteArray();
    return Arrays.copyOfRange(bytes, 14, bytes.length);
  }