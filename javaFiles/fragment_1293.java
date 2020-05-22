public void addListeners() {
    final Point offset = new Point();
    addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(final MouseEvent e) {
            offset.setLocation(e.getPoint());
        }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(final MouseEvent e) {
            setLocation(e.getXOnScreen()-offset.x, e.getYOnScreen()-offset.y);
        }
    });
}