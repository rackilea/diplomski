public void paint(Graphics g) {
    super.paint(g);
    g.setColor(new Color(255,255,255));
    g.drawRect(10, 10, 60, 50);
    g.drawLine(60, 50, 220, 20);
    g.drawString(symbols, 10, 150);
}