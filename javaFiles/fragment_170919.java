public static BufferedImage loadRgbImage (String filename) {
    BufferedImage originalImage = ImageIO.read(filename); 
    BufferedImage rgbImage;
    if (originalImage.getType() == BufferedImage.TYPE_3BYTE_BGR) {
        rgbImage = originalImage; // no need to convert, just return original
    } else {
        rgbImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        rgbImage.getGraphics().drawImage(originalImage, 0, 0, null);
    }
    return rgbImage; 
}