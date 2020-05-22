int[] pixels = img.getData().getPixels(
    0, 0, img.getWidth(), img.getHeight(),
    new int[0]);

byte[] bytes = pixels.length * 4;
ByteBuffer.wrap(bytes).asIntBuffer().put(pixels);