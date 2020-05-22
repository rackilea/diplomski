@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);  // *** add this ***
    g.setColor(color);
    g.fillOval(100, 100, 100, 100);
}