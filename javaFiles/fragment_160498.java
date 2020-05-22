public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D) gr;

    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    BasicStroke wideStroke = new BasicStroke(24.0f);
    g.setStroke(wideStroke);

    LinearGradientPaint lgp = new LinearGradientPaint(
            new Point2D.Float(0, 160),
            new Point2D.Float(160, 0),
            new float[] {0f, 0.5f, 1f},
            new Color[] {Color.green, Color.yellow, Color.red}
            );

    g.setPaint(lgp);

    g.draw(new Arc2D.Double(25, 25, 200, 200, 180, -90, Arc2D.OPEN));
}