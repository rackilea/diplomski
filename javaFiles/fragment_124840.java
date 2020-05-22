public BufferedImage res20x20(BufferedImage image){

    int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
    BufferedImage resizedIm= new BufferedImage(20, 20, type);
    Image scaledImage = inputImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    resizedIm.getGraphics().drawImage(scaledImage, 0, 0, null);
    return resizedIm;
}