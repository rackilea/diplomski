public void mouseMoved(MouseEvent e) {

        if (!isDrawingMode) return; //if isDrawingMode is false, it will not trigger to draw
        Point point = e.getPoint();
        pointList.add(point);

        repaint();

}