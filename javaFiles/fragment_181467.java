@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    if(null != backgroundImage) {
        g2d.drawImage(backgroundImage, 0, 0, null);
    }
}