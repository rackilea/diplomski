public void setColor(int newR, int newG, int newB) {
    r = newR;
    g = newG;
    b = newB;
    myGreen = new Color(r, g, b);
    repaint();
}