@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.GREEN);
    g.fillOval(x, y, 15, 15);
}