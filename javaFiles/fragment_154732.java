private void drawGrid(Graphics g, int x, int y, int width) {
    // draw box around grid (not necessary)
    //g.drawRect(x, y, width, width);

    // draw vertical grid lines
    g.drawLine(width / 3 + x, y, width / 3 + x, y + width);
    g.drawLine(width / 3 * 2 + x, y, width / 3 * 2 + x, y + width);

    // draw horizontal grid lines
    g.drawLine(x, width / 3 + y, x + width, width / 3 + y);
    g.drawLine(x, width / 3 * 2 + y, x + width, width / 3 * 2 + y);
}