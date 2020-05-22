private BufferedImage resizeImage(BufferedImage originalImage, int width, int height)
        throws IOException {
    BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, width, height, null);
    g.dispose();
    return resizedImage;
}