public static BufferedImage loadRgbImage (String filename) {
    // load the original image
    BufferedImage originalImage = ImageIO.read(filename); 
    // create buffer for converted image in RGB format
    BufferedImage rgbImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    // render original image into buffer, changes to destination format
    rgbImage.getGraphics().drawImage(originalImage, 0, 0, null);
    return rgbImage; 
}