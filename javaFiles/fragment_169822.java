/**
 * 
 */
public void zoomOut(Point point) {
    this.imagePanel.setZoom(this.imagePanel.getZoom() * 0.9f);
    Point pos = this.getViewport().getViewPosition();

    int newX = (int)(point.x*(0.9f - 1f) + 0.9f*pos.x);
    int newY = (int)(point.y*(0.9f - 1f) + 0.9f*pos.y);
    this.getViewport().setViewPosition(new Point(newX, newY));

    this.imagePanel.revalidate();
    this.imagePanel.repaint();
}

/**
 * 
 */
public void zoomIn(Point point) {
    this.imagePanel.setZoom(this.imagePanel.getZoom() * 1.1f);
    Point pos = this.getViewport().getViewPosition();

    int newX = (int)(point.x*(1.1f - 1f) + 1.1f*pos.x);
    int newY = (int)(point.y*(1.1f - 1f) + 1.1f*pos.y);
    this.getViewport().setViewPosition(new Point(newX, newY));

    this.imagePanel.revalidate();
    this.imagePanel.repaint();
}