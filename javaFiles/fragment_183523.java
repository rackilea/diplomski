BufferedImage bImg ;
if (awtImage instanceof BufferedImage) {
    bImg = (BufferedImage) awtImage ;
} else {
    bImg = new BufferedImage(awtImage.getWidth(null), awtImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bImg.createGraphics();
    graphics.drawImage(awtImage, 0, 0, null);
    graphics.dispose();
}
Image fxImage = SwingFXUtils.toFXImage(bImg, null);