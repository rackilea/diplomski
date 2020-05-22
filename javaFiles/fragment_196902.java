public static BufferedImage getFrameImage(JFrame argFrame){
    int w = argFrame.getWidth();
    int h = argFrame.getHeight();
    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bi.createGraphics();
    g.setColor(Color.white);
    g.fillRect(0, 0, w, h);
    argFrame.paint(g);
    paint(g);
    return bi;
}