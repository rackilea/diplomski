File f = new File("/path");
BufferedImage bufferedImage = ImageIO.read(f);

WritableRaster raster = bufferedImage.getRaster();
DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

byte[] array = data.getData();

invokeJNIMethodWithOpenCL(array);


//....
private native void invokeJNIMethodWithOpenCL(byte[] array);