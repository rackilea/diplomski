BufferedImage imgBuffer = ImageIO.read(new File("example.gif"));

//Save image as reference
File outputfile = new File("temp/image.png");
ImageIO.write(imgBuffer, "png", outputfile);

//My correspondance

int curCVtype = CvType.CV_8UC4; //Default type
boolean supportedType = true;

switch (imgBuffer.getType()) {
case BufferedImage.TYPE_3BYTE_BGR:
    curCVtype = CvType.CV_8UC3;
    break;
case BufferedImage.TYPE_BYTE_GRAY:
case BufferedImage.TYPE_BYTE_BINARY:
    curCVtype = CvType.CV_8UC1;
    break;
case BufferedImage.TYPE_INT_BGR:
case BufferedImage.TYPE_INT_RGB:
    curCVtype = CvType.CV_32SC3;
    break;
case BufferedImage.TYPE_INT_ARGB:
case BufferedImage.TYPE_INT_ARGB_PRE:
    curCVtype = CvType.CV_32SC4;
    break;
case BufferedImage.TYPE_USHORT_GRAY:
    curCVtype = CvType.CV_16UC1;
    break;
case BufferedImage.TYPE_4BYTE_ABGR:
case BufferedImage.TYPE_4BYTE_ABGR_PRE:
    curCVtype = CvType.CV_8UC4;
    break;
default:
    // BufferedImage.TYPE_BYTE_INDEXED;
    // BufferedImage.TYPE_CUSTOM;
    System.out.println("Unsupported format:" + imgBuffer.getType());
    supportedType = false;
}

//Convert to Mat
Mat img = new Mat(imgBuffer.getHeight(), imgBuffer.getWidth(), curCVtype);
if (supportedType) {
    // Insert pixel buffer directly
    byte[] pixels = ((DataBufferByte) imgBuffer.getRaster().getDataBuffer()).getData();
    img.put(0, 0, pixels);
} else {
    // Convert to RGB first
    int height = imgBuffer.getHeight();
    int width = imgBuffer.getWidth();
    int[] pixels = imgBuffer.getRGB(0, 0, width - 1, height - 1, null, 0, width);

    // Convert ints to bytes
    ByteBuffer byteBuffer = ByteBuffer.allocate(pixels.length * 4);
    IntBuffer intBuffer = byteBuffer.asIntBuffer();
    intBuffer.put(pixels);

    byte[] pixelBytes = byteBuffer.array();

    img.put(0, 0, pixelBytes);

    // Reorder the channels for Opencv BGRA format from
    // BufferedImage ARGB format
    Mat imgMix = img.clone();
    ArrayList<Mat> imgSrc = new ArrayList<Mat>();
    imgSrc.add(imgMix);

    ArrayList<Mat> imgDest = new ArrayList<Mat>();
    imgDest.add(img);

    int[] fromTo = { 0, 3, 1, 2, 2, 1, 3, 0 }; //Each pair is a channel swap
    Core.mixChannels(imgSrc, imgDest, new MatOfInt(fromTo));
}

//Save output image
Imgcodecs.imwrite("temp/image_mat.png", img);