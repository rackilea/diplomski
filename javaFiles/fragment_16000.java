public void paintComponent(Graphics g) {
    super.paintComponents(g);

    g.setColor(Color.BLUE);
    g.drawOval(250 - radius, 250 - radius, radius * 2, radius * 2);
    radius += 10;

    if (radius + 10 < 250) {
        paintComponent(g);
    }
}