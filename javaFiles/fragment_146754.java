public void paintComponent (Graphics g) {
    super.paintComponent(g);
    double row = 10;        
    double add = 0.25;
    int y = 15;
    for(int i = 1; i <= 8; i++) {
        row = row + add;
        g.drawString( i + "        " + row, 10, y +=15);
    }
}