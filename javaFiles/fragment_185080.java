private void drawBorder(Graphics g) {
    int x1 = 0;
    int y1 = 0;
    int x2 = this.getSize().width-1;
    int y2 = this.getSize().height-6;
    g.setColor(Color.GRAY);
    g.drawRect(x1, y1, x2, y2); 
}