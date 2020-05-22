Color color = Color.red; 
@Override //This Method changes the background colour of the JMenuBar
protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(color);
    g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

}
...
chkbtnSmartSize.setBackground(color);