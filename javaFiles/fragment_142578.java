Path path = Paths.get("lena.raw");
byte[] content = Files.readAllBytes(path);
IntBuffer buf = ByteBuffer.wrap(content) /*.order(ByteOrder.LITTE_ENDIAN)*/ .asIntBuffer();
int[] rgb = new int[content.length / 4];
buf.get(rgb);
BufferedImage outImage = new BufferedImage(width, length, BufferedImage.TYPE_INT_ARGB);
outImage.setRGB(0, 0, width, height, rgb, 0, width);
ImageIO.write(outImage, "png", new FileOutputStream(...));