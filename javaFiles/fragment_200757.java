@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
        g.drawImage(image, 0, 0, (int) getSize().getWidth() - 0, (int) getSize().getHeight() - 0, this);
    }
}