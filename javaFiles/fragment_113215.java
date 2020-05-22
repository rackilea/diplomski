public void mouseDragged(MouseEvent e) {
    dog.setLocation(xposR, yposR);
    xposR = e.getX();
    yposR = e.getY();
    repaint();
}