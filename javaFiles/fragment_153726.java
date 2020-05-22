@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); //ALWAYS call this method first!

    Graphics2D g2d = (Graphics2D) g;
    g2d.draw(new Rectangle2D.Double(10, 10, 50, 50));
    g2d.fill(new Rectangle2D.Double(150, 10, 50, 50));

    g2d.draw(new Rectangle2D.Double(10, 75, 100, 50));
    g2d.fill(new Rectangle2D.Double(150, 75, 100, 50));

    g2d.draw(new Polygon(new int[] {35, 10, 60}, new int[] {150, 200, 200}, 3));
    g2d.fill(new Polygon(new int[] {185, 150, 215}, new int[] {150, 200, 200}, 3));

    g2d.dispose();
    g.dispose();
}