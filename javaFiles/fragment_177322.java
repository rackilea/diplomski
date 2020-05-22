@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    BufferedImage img = images[random()];
    g.drawImage(img, 0, 0, 400, 400, 0, 0,
                           img.getWidth(), img.getHeight(), this);
}