int x = 50;
    int y = 50;
    int size = 100;

    g.setColor(Color.red);
    g.fillOval(x, y, size, size);

    int center = x + size / 2;
    size = 70;
    g.setColor(Color.blue);
    g.fillOval(center - size / 2, center - size / 2, size, size);