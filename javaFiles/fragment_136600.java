public void mouseDragged(MouseEvent e) {
    int x = i.getX() + e.getX() - lastX;
    int y = i.getY() + e.getY() - lastY;

    if (selected != null) {
        moveImage(selected,x,y);
        repaint();
    }
    lastX = e.getX();
    lastY = e.getY();
}