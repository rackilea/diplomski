public BufferedImage scaleImage(int multiplier, BufferedImage img) {

    BufferedImage bi = new BufferedImage(multiplier * img.getWidth(null), multiplier * img.getHeight(null), BufferedImage.TYPE_INT_RGB);

    Graphics2D grph = (Graphics2D) bi.getGraphics();
    grph.scale(multiplier, multiplier);

    // everything drawn with grph from now on will get scaled.
    grph.drawImage(img, 0, 0, null);
    grph.dispose();

    return bi;
}