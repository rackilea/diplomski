@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    if (draw) {
        g2.drawImage(Menu, 0, 0, getWidth(), getHeight(), null); 
    }
}