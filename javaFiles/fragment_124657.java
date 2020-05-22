// BufferedImage -> byte sequence
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(img, "PNG", baos);
byte[] imageData = baos.toByteArray();
// byte sequence -> BufferedImage
ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
BufferedImage img = ImageIO.read(bais);