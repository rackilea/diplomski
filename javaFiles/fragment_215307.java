addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        segments.add(0, new Segment());
        segments.get(0).points.add(e.getPoint());
    }
});

addMouseMotionListener(new MouseMotionAdapter() {
    public void mouseDragged(MouseEvent e) {
        segments.get(0).points.add(e.getPoint());
        repaint();
    }
});