addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent me) {
        // Get x,y and store them
        pX = me.getX();
        pY = me.getY();
    }
});
addMouseMotionListener(new MouseMotionAdapter() {
    public void mouseDragged(MouseEvent me) {
        parent.setLocation(parent.getLocation().x + me.getX() - pX, 
                parent.getLocation().y + me.getY() - pY);
    }
});