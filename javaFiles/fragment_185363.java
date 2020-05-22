pixels = BufferUtils.createByteBuffer(bytePixels.length);
pixels.put(bytePixels);
pixels.flip();
for (int i = 0; i < pixels.length; i += 3) {
    byte t = pixels[i];
    pixels[i] = pixels[i+2];
    pixels[i+2] = t;
}