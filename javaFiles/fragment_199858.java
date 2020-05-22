private class MyMouseListener extends MouseAdapter {
    @Override
    public void mousePressed(final MouseEvent e) {
        Point clickedPoint = e.getPoint();
        if (regenerate.rect.contains(new Point(clickedPoint.x - regenerate.Position[0], clickedPoint.y - regenerate.Position[1]))) {
            repaint();
            return;
        }
    }
}