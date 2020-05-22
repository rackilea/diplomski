public void paintComponent(Graphics g) {
    // both paint and paintComponent work - difference?
    super.paintComponent(g);    // call superclass's paintComponent
    if (right && up) {
        g.drawLine(x, y, x + 20, y);               // body - drawn in terms of x
        g.drawLine(x + 15, y - 5, x + 15, y + 5);    // wing
        g.drawLine(x, y - 2, x, y + 2);
        x++;
        if (x == getWidth() - 25) {
            right = false;
            up = false;
        }
    } else if (!right && !up) {
        g.drawLine(x, y, x, y + 20);               // body - drawn in terms of x
        g.drawLine(x - 5, y + 15, x + 5, y + 15);    // wing
        g.drawLine(x - 2, y, x + 2, y);
        y++;
        if (y == getHeight() - 25) {
            up = true;
        }
    } else {
        if (x <= getWidth() - 15 && x > 20) {
            g.drawLine(x, y, x + 20, y);               // body - drawn in terms of x
            g.drawLine(x + 5, y - 5, x + 5, y + 5);    // wing
            g.drawLine(x + 20, y - 2, x + 20, y + 2);
            x--;
        }
        if (x == 20) {
            g.drawLine(x, y, x, y + 20);               // body - drawn in terms of x
            g.drawLine(x - 5, y + 5, x + 5, y + 5);    // wing
            g.drawLine(x - 2, y + 20, x + 2, y + 20);
            y--;
        }
        if (y == 10) {
            right = true;
        }
    }
}