private class MouseHandler extends MouseAdapter {  
    public void mouseDragged(MouseEvent e) {
        pointends[ pointCount - 1 ] = e.getPoint(); // note the "- 1"
        repaint();
    }
    public void mousePressed(MouseEvent e) {
        if(pointCount < points.length) {
            points[ pointCount ] = e.getPoint();
            pointends[ pointCount ] = e.getPoint(); // add end point
            pointCount++; 
            repaint();
        }
    }
    public void mouseReleased(MouseEvent e) { // do nothing
    }
}