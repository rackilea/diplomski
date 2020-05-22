@Override
public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    int w2 = getWidth() / 2;
    int h2 = getHeight() / 2;
    g2d.rotate(-Math.PI / 2, w2, h2);
    super.paintComponent(g);
}