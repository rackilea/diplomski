// Create an image type grayscale
BufferedImage image = new BufferedImage(2, 2, BufferedImage.TYPE_BYTE_GRAY);

// Get the backing pixels, and copy into it
byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
System.arraycopy(bytes, 0, data, 0, bytes.length);

// Write it out:
ImageIO.write(image, "jpg", new File("yourPathHere");