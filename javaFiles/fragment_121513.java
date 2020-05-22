@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    FontMetrics fm = g.getFontMetrics();
    int y = fm.getFontHeight() + fm.getAscent();
    System.out.println("X:"+getX()+"Y:"+getY());
    g.drawString("Test", 0, y);
}