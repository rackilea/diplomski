public void paintIcon(Component c, Graphics g, int x, int y){
    Graphics2D g2 = (Graphics2D) g;
    Ellipse2D.Double circle = new Ellipse2D.Double(x, y, size, size);
    g2.setColor(c.getForeground()); // <-- get foreground color from parent.
    g2.fill(circle);
}