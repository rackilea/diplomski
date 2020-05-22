public void paintPoint(final int absoluteX, final int absoluteY, final int nextX,
  final int nextY, final Graphics g, final ITracePoint2D original) {
  g.setColor(this.getColor());
  g.fillRect(absoluteX - this.m_halfWidth, absoluteY, 2 * this.m_halfWidth, this.m_chart
    .getYChartStart()
    - absoluteY);
}