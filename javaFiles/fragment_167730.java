private void updatePreferredSize(int n, Point p) {
    double d = (double) n * 1.08;
    d = (n > 0) ? 1 / d : -d;

    int w = (int) (getWidth() * d);
    int h = (int) (getHeight() * d);
    preferredSize.setSize(w, h);

    int offX = (int)(p.x * d) - p.x;
    int offY = (int)(p.y * d) - p.y;
    setLocation(getLocation().x-offX,getLocation().y-offY);

    getParent().doLayout();
}