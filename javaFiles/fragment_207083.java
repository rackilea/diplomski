class PngImageSourceStream extends ImageSourceStream {

  public PngImageSourceStream(int width, int height, int frameRate,
      Vector<String> images) {
    super(width, height, frameRate, images);

    // configure the new format as RGB format
    format = new RGBFormat(new Dimension(width, height),
        Format.NOT_SPECIFIED, Format.byteArray, frameRate, 
                                  24, // 24 bits per pixel
                                  1, 2, 3); // red, green and blue masks when data are in the form of byte[]
  }

  public void read(Buffer buf) throws IOException {

    // Check if we've finished all the frames.
    if (nextImage >= images.size()) {
      // We are done. Set EndOfMedia.
      System.err.println("Done reading all images.");
      buf.setEOM(true);
      buf.setOffset(0);
      buf.setLength(0);
      ended = true;
      return;
    }

    String imageFile = (String) images.elementAt(nextImage);
    nextImage++;

    System.err.println("  - reading image file: " + imageFile);

    // read the PNG image
    BufferedImage image = ImageIO.read(new File(imageFile));
    boolean hasAlpha = image.getColorModel().hasAlpha();
    Dimension size = format.getSize();

    // convert 32-bit RGBA to 24-bit RGB
    byte[] imageData = convertTo24Bit(hasAlpha, image.getRaster().getPixels(0, 0, size.width, size.height, (int[]) null));
    buf.setData(imageData);

    System.err.println("    read " + imageData.length + " bytes.");

    buf.setOffset(0);
    buf.setLength(imageData.length);
    buf.setFormat(format);
    buf.setFlags(buf.getFlags() | Buffer.FLAG_KEY_FRAME);
  }

  private void convertIntByteToByte(int[] src, int srcIndex, byte[] out, int outIndex) {
    // Note: the int[] returned by bufferedImage.getRaster().getPixels()
    // is an int[]
    // where each int is the value for one color i.e. the first 4 ints
    // contain the RGBA values for the first pixel
    int r = src[srcIndex];
    int g = src[srcIndex + 1];
    int b = src[srcIndex + 2];

    out[outIndex] = (byte) (r & 0xFF);
    out[outIndex + 1] = (byte) (g & 0xFF);
    out[outIndex + 2] = (byte) (b & 0xFF);
  }

  private byte[] convertTo24Bit(boolean hasAlpha, int[] input) {
    int dataLength = input.length;
    int newSize = (hasAlpha ? dataLength * 3 / 4 : dataLength);
    byte[] convertedData = new byte[newSize];

    // for every 4 int values of the original array (RGBA) write 3
    // bytes (RGB) to the output array
    // if there is no alpha (i.e. RGB image) then just convert int to byte
    for (int i = 0, j = 0; i < dataLength; i += 3, j += 3) {
      convertIntByteToByte(input, i, convertedData, j);
      if (hasAlpha) {
        i++; // skip an extra byte if the original image has an
            // extra int for transparency
      }
    }
    return convertedData;
  }

}