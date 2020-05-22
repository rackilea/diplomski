protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D)gr;
    ...

    // Draw a rectangle
    g.drawRect(0,0,50,100);
}