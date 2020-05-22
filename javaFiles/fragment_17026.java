public void getShape(final Graphics g, final String note) {
    MouseListener[] listeners = this.getMouseListeners();
    for (MouseListener ml : listeners) {
        this.removeMouseListener(ml);
    }
    this.addMouseListener(new MouseListener()...);
}