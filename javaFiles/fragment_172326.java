@Override
protected void paintComponent(Graphics g) { // protected, not public

    // super.paint(g);       // ******** REMOVE *********
    super.paintComponent(g); // ******** ADD *********

    Graphics2D g2d = (Graphics2D) g;
    g2d.fillOval(sX, sY, width, height);
}