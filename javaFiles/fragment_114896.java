@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int width = this.getWidth();
    int height = this.getHeight();
    g.setColor(Color.black);
    g.fillRect(0, 0, width, height);
    ...
}