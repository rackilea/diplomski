@Override
public void mousePressed(final MouseEvent e) {
    e.translatePoint(e.getComponent().getLocation().x, e.getComponent().getLocation().y);
    px = e.getX();
    py = e.getY();
}