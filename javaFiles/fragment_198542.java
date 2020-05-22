private void displayOvals(Graphics g, int radius, int centerx, int centery) {
    if (radius >= 5) {
        g.drawOval(centerx - radius, centery - radius, 2 * radius, 2 * radius);

        displayOvals(g, radius - 5, centerx, centery);
    }
}