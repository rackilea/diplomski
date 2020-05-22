protected void paintComponent(Graphics g) {
    super.paintComponent(g);  
    g.setColor(Color.YELLOW);
    g.fillRect(0,0,getWidth(), getHeight());
    g.setColor(Color.BLUE);
    g.drawString("Movie Sceen", 130, 20);   
}