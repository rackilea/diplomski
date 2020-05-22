@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.fill(new Ellipse2D.Double(x, y, 70, 70));
}