BufferedImage bi;
....
private void setImage(JPanel panel) {
    Dimension d = panel.getPreferredSize();
    int w = (int)d.getWidth();
    int h =(int)d.getHeight();
    bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bi.createGraphics();
    panel.paint(g);
    g.dispose();
}