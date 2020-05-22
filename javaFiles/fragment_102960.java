public static byte[] convert(byte[] bytes, Color backgroundColor) throws Exception
{
    ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
    BufferedImage bufferedImage = ImageIO.read(inputStream);
    BufferedImage newBi = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = (Graphics2D) newBi.getGraphics();
    g2d.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), backgroundColor, null);
    bufferedImage.getHeight(), null);
    ByteArrayOutputStream osByteArray = new ByteArrayOutputStream();
    ImageOutputStream outputStream = ImageIO.createImageOutputStream(osByteArray);
    ImageIO.write(newBi, "jpg", outputStream);
    outputStream.flush();
    outputStream.close();
    return osByteArray.toByteArray();
}