@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    ...
    g.drawLine(p1.x, p1.y, p2.x, p2.y);
    ...
    g.setColor(Color.black);
    g.drawString("My Text", 0, 20);
}