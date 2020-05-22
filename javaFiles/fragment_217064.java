int w = jpanel.getWidth();
int h = jpanel.getHeight();
BufferedImage bi = new BufferedImage(w, h,
    BufferedImage.TYPE_INT_RGB);
Graphics2D g2 = bi.createGraphics();
jpanel.paint(g2);
g2.dispose();