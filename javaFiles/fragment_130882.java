public void mouseDragged(MouseEvent e) {
    int minX = Math.min(e.getX(), clickPoint.x);
    int minY = Math.min(e.getY(), clickPoint.y);
    int maxX = Math.max(e.getX(), clickPoint.x);
    int maxY = Math.max(e.getY(), clickPoint.y);

    selection.x = minX;
    selection.y = minY;
    selection.width = maxX - minX;
    selection.height = maxY - minY;
    repaint();
}