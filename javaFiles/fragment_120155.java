jt.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int r = jt.rowAtPoint(evt.getPoint());
        int c = jt.columnAtPoint(evt.getPoint());
        if (r >= 0 && c >= 0) {
            ......

        }
    }
});