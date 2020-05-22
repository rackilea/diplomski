public void poligon(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Polygon pol;

    // the x and y coordinates of the vertices of your hexagon
    int x[] = {375, 400, 450, 475, 450, 400};
    int y[] = {150, 100, 100, 150, 200, 200};

    // how much to offset the x and y coordinates by
    int xOffset = 100;
    int yOffset = 20;

    // offset your hexagon until you narrow down the right position
    for(int i = 0; i < x.length; ++i) {
        x[i] += xOffset;
        y[i] -= yOffset;
    }

    pol = new Polygon(x, y, x.length);
    g2d.setPaint(Color.red);
    g2d.fill(pol);
}