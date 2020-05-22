addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {
        segments.add(new Segment());
    }
});

addMouseMotionListener(new MouseMotionAdapter() {
    @Override
    public void mouseDragged(MouseEvent e) {
       segments.get(segments.size() - 1).points.add(e.getPoint());
       repaint();
    }
});