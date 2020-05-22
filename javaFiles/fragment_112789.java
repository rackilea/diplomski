@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    for (int i = 1; i < point.size(); i++) {
        g2.setColor(colors.get(i));
        g2.setStroke(brushes.get(i));
        g2.draw(new Line2D.Float(point.get(i).x, point.get(i).y));
    }
}