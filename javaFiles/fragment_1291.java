protected void paintComponent(Graphics g) {
    if (point != null) {
        g.setColor(Color.red);
        g.drawRect(point.x, point.y, 60, 20);
        g.setColor(Color.blue);
        g.drawRect(point.x, point.y, 20, 60);
    }
}