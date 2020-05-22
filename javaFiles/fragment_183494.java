public static void convertToGrayscale() throws Exception {

    JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(new FileInputStream(new      File("a.jpg")));
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(new   FileOutputStream("b.jpg"));
    BufferedImage sourceImg = decoder.decodeAsBufferedImage();
    BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    BufferedImage destImg = op.filter(sourceImg, null);
    encoder.encode(destImg);
    decoder = null;
    encoder = null;