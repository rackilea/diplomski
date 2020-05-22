public void mouseClicked(MouseEvent e) {
    icon1 = true;
    icon2 = false;
    icon3 = false;
    imagePanel.repaint();
}
....
protected void paintComponent(Graphics g) {
    if (icon1) {
        g.drawImage(image1, .....);
    }
    if (icon2) { ... }
    if (icon3) { ... }
}