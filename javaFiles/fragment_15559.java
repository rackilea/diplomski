int[] pixels = new int[bytes.length / 4];
ByteBuffer.wrap(bytes).asIntBuffer().get(pixels);

img.getRaster().setPixels(0, 0, img.getWidth(), img.getHeight(), pixels);

ImageIO.write(img, "png", new File("output.png"));