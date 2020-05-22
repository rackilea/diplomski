private void canvas1MouseMoved(java.awt.event.MouseEvent evt) {                                   
    // TODO add your handling code here:
    canvas1.addNewPosition(new Position(evt.getX(),evt.getY()));
    canvas1.removeLastPosition();
    repaint();

    /*
    canvas1.setX(evt.getX());
    canvas1.setY(evt.getY());*/        
}