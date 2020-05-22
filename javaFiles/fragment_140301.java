int width = 256;
int height = 256;
final int bytes_per_pixel = 4;
byte[] raw = new byte[width * height * bytes_per_pixel];
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
IntBuffer intBuf
        = ByteBuffer.wrap(raw)
        .order(ByteOrder.LITTLE_ENDIAN)
        .asIntBuffer();
int[] array = new int[intBuf.remaining()];
intBuf.get(array);
image.setRGB(0, 0, width, height, array, 0, width);