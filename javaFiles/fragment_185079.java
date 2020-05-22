private void drawWhiteSpace(Graphics g) {
    int x1 = 0;
    int y1 = this.getSize().height-6;
    int x2 = this.getSize().width;
    int y2 = this.getSize().height;
    g.setColor(Color.WHITE);
    g.fillRect(x1, y1, x2, y2);     
}