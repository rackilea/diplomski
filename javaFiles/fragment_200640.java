// Can be removed
addMouseMotionListener(new MouseMotionAdapter() {    
    @Override
    public void mouseDragged(MouseEvent e) {
        points.add(e.getPoint());
        repaint();
    }
});