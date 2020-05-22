@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int y = 50;
    for (int i = 0; i < lineModel.getLines(); i++) {
        g.drawLine(50, y, 200, y);
        y += 20;
    }
}