int w = 640;
int h = 480;

byte[] imageBytes = new byte[w * h];

// 1 Keeps the image "managed" at the expense of twice the memory + a large array copy
BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
image.getRaster().setDataElements(0, 0, w, h, imageBytes);

System.out.println("image: " + image);

// 2 Faster, and uses less memory, but will make the image "unmanaged"
ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
WritableRaster raster = Raster.createInterleavedRaster(new DataBufferByte(imageBytes, imageBytes.length), w, h, w, 1, new int[]{0}, null);
BufferedImage image2 = new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);

System.out.println("image2: " + image2);