@Override
public void paintComponents(Graphics g) {
//  Graphics2D g2d = (Graphics2D) g;
//  super.paint(g2d);
    Graphics p = bi.getGraphics();
    for (int i = 0; i < images.length; i++) {
        BufferedImage im = images[i];
        int ciw = getWidth() / 3;
        int cih = getHeight() / 2;
        int xpos = i % 3;
        int ypos = i / 3;
        int ix = i * ciw * xpos;
        int iy = i * cih * ypos;
        int iw = ciw;
        int ih = cih;
        p.drawImage(im, ix, iy, iw, ih, null);
    }
    drawPanel.drawImage(bi, 0, 0, null);
//  drawPanel.paintComponents(p);
//  drawPanel.repaint();
}