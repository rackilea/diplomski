@Override
public void mouseDragged(MouseEvent e) {
    double dX;
    double dY;
    if (inVertex >= 0) {
        this.endX = e.getX();
        this.endY = e.getY();
        dX = startX - endX;
        dY = startY - endY;
        this.width += dX;
        this.height += dY;

        this.startX = this.endX;
        this.startY = this.endY;

        this.repaint();
    }
}