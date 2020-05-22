super.paintComponent(g);
int x = 0;
for (BufferedImage img : docList) {
    g.drawImage(img, x, 0, this);
    x += img.getWidth();
}