public void drawRectangle(double x, double y, int xs, int ys, int colour){
    if(xs <= 0){
        return;
    }
    x -= xScroll;
    y -= yScroll;
    BufferedImage image = new BufferedImage(xs, ys, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = (Graphics2D) image.getGraphics();
    g.setColor(new Color(colour));
    g.fillRect(0, 0, xs, ys);
    g2d.drawImage(image, (int)x, (int)y, null);
    g.dispose();
}