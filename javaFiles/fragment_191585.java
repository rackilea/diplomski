public void paintComponent(Graphics g)
{
    Graphics2D g2 = (Graphics2D) g;

    Point2D.Double from = new Point2D.Double(300, 100);
    Point2D.Double to = new Point2D.Double(300, 300);

    Line2D.Double line = new Line2D.Double(from, to);
    g2.draw(line);

    Point2D.Double from2 = new Point2D.Double(150, 200);
    Point2D.Double to2 = new Point2D.Double(450, 200);
    Line2D.Double line2 = new Line2D.Double(from2, to2);
    g2.draw(line2);

    g2.drawString("-1", 290, 215);
}