protected void paintComponent(Graphics g)
{
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g.create();

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2d.setColor(_color);
    g2d.setStroke(new BasicStroke(_thickness));
    g2d.drawLine(_startX, _startY, _endX, _endY);

    g2d.dispose();
}