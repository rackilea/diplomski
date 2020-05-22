@Override
protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
    Graphics2D g2D = (Graphics2D) g;
    int xp[] = new int[]{x, x, x + w, x + w, x};
    int yp[]  = new int[]{y, y + h, y + h, y, y};

    shape = new Polygon(xp, yp, xp.length);
    if (isSelected) {
        g2D.fill(shape);
        g2D.setColor(selectColor);
    } else if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
        g2D.setColor(deSelectColor);
    }
}