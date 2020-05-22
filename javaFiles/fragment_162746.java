MouseListener ma = new MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setBackground(Color.RED);
    }
    public void mouseExited(MouseEvent e) {
        e.getComponent().setBackground(null);
    }
};