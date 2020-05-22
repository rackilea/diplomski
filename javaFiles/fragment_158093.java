@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.red);
    for (int i=0; i<pSize; i++){
        g2d.fillOval(punkter.get(i).x, punkter.get(i).y, 5, 5);   
    }
    if (pSize==4) {
        drawBezier(pSize,4,g);
    }
}