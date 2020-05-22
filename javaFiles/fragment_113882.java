public void paint(Graphics g) {
    Graphics2D g2d1 = (Graphics2D) g;
    g.setColor(getBackground());
    g.fillRect(0,0,getWidth(),getHeight()); // draw a rectangle over the display area in the bg color
    g.setColor(Color.BLACK);
    g2d1.fillRect(0, 100, 30, i);
}