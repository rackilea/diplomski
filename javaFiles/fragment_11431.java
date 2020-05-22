private Image getImageFromBytes(byte[] imgBytes) {
    try {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imgBytes);
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        return SwingFXUtils.toFXImage(bufferedImage, null);
    } catch (IOException e) {
        e.printStackTrace();
    } 
    return null;
}