@Override
public void componentResized(ComponentEvent arg0) {
    int W = 4;  
    int H = 3;  
    Rectangle b = arg0.getComponent().getBounds();
    arg0.getComponent().setBounds(b.x, b.y, b.width, b.width*H/W);
}