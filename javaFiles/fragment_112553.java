@Override
public void paintComponent(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillOval(x, y, 15, 15);
}

@Override
public void paint(Graphics g) {
    dbImage = createImage(getWidth(), getHeight());
    dbg = dbImage.getGraphics();
    paintComponent(dbg);
    g.drawImage(dbImage, 0, 0, this);
}