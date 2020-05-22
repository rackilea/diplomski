public void paint(Graphics g) {
    g.clearRect(0, 0, getWidth(), getHeight());
    for(Component c: getContentPane().getComponents()) {
        c.repaint();
    }
}