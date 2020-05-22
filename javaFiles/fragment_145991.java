final JButton btn = new JButton("repeat");
btn.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        btn.setText("hover");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        btn.setText("repeat");
    }
});