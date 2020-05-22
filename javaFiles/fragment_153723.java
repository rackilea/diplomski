@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); //ALWAYS call this method first!
    g.drawRect(10, 10, 50, 50); //Draws square
    g.drawRect(10, 75, 100, 50); //Draws rectangle
    g.drawPolygon(new int[] {35, 10, 60}, new int[] {150, 200, 200}, 3); //Draws triangle
}