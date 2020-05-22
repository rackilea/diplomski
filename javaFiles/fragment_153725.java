@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); //ALWAYS call this method first!
    g.drawRect(10, 10, 50, 50); //Draws square
    g.fillRect(150, 10, 50, 50); //Fills a square
    g.drawRect(10, 75, 100, 50); //Draws rectangle
    g.fillRect(150, 70, 100, 50); //Fills a square
    g.drawPolygon(new int[] {35, 10, 60}, new int[] {150, 200, 200}, 3); //Draws triangle
    g.fillPolygon(new int[] {185, 150, 215}, new int[] {150, 200, 200}, 3); //Fills triangle
    g.dispose();
}