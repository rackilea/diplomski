protected void paintComponent(Graphics g) {
    // Paint the default look.
    super.paintComponent(g);

    // Your custom painting here.
    g.drawImage(foregroundImage, x, y, this);
}