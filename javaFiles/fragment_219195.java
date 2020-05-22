public void drawImage(BufferedImage img, double x, double y, double scale){
    x -= xScroll;
    y -= yScroll;
    BufferedImage image = new BufferedImage((int)(img.getWidth()*scale), (int)(img.getHeight()*scale), BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    g.drawImage(img, 0, 0, (int)(img.getWidth()*scale), (int)(img.getHeight()*scale), null);
    g2d.drawImage(image, (int)x, (int)y, null);
    g.dispose();
}