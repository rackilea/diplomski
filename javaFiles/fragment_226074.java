plot.setRenderer(new BoxAndWhiskerRenderer() {

    @Override
    public void drawVerticalItem(Graphics2D g2, …) {
        // existing code that calls the methods below
    }

    private void drawEllipse(Point2D point, double oRadius, Graphics2D g2) {
        Paint temp = g2.getPaint();
        g2.setColor(Color.black);
        Ellipse2D dot = new Ellipse2D.Double(point.getX() + oRadius / 2,
                point.getY(), oRadius, oRadius);
        g2.draw(dot);
        g2.setPaint(temp);
    }

    private void drawHighFarOut(double aRadius, Graphics2D g2, double xx,
            double m) {
        Paint temp = g2.getPaint();
        g2.setColor(Color.black);
        double side = aRadius * 2;
        g2.draw(new Line2D.Double(xx - side, m + side, xx + side, m + side));
        g2.draw(new Line2D.Double(xx - side, m + side, xx, m));
        g2.draw(new Line2D.Double(xx + side, m + side, xx, m));
        g2.setPaint(temp);
    }
}