private void drawCar(Graphics g, int x, int y) {
    g.fillOval(x, y, 10, 10);
    g.fillOval(x + 20, y, 10, 10);
    // Draw the car body
    g.setColor(Color.BLUE);
    g.fillRect(x - 10, y - 10, 50, 10);
    // Draw the top
    g.setColor(Color.DARK_GRAY);
    Polygon polygon = new Polygon();
    polygon.addPoint(x, y - 10);
    polygon.addPoint(x + 10, y - 20);
    polygon.addPoint(x + 20, y - 20);
    polygon.addPoint(x + 30, y - 10);
    g.fillPolygon(polygon);
}