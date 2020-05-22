@Override
public void paint(Graphics g) {
    // fill background
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, getWidth(), getHeight());

    int x25 = this.getWidth() / 4;
    int x75 = this.getWidth() * 3 / 4;
    int y25 = this.getHeight() / 4;
    int y75 = this.getHeight() * 3 / 4;

    // draw inner lines
    g.setColor(Color.LIGHT_GRAY);
    int width = x75 - x25;
    double step = width / 40.0;
    for (double i = 0; i < width; i += step) {
        g.drawLine((int)(x25 + i), y25, (int)(x75 - i), y75);
    }

    // draw outer lines
    g.setColor(Color.BLACK);
    g.drawLine(x25, y25, x75, y25);
    g.drawLine(x25, y75, x75, y75);
    g.drawLine(x25, y25, x75, y75);
    g.drawLine(x75, y25, x25, y75);
}