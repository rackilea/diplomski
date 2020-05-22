@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("In paint component");
    xBase = xBase + 20;
    drawCar(g, xBase, yBase);// draw the first car
    drawCar(g, xBase + 80, yBase);// draw the second car 80 pixels ahead 
    drawCar(g, xBase, yBase + 100); // draw the third car 100 pixels lower

    g.dispose();
}