@Override
protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g;
  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
  g2.setColor(CIRCLE_COLOR);
  for (int i = 0; i < currentCirclesToDraw && i < ellipseList.size(); i++) {
     g2.fill(ellipseList.get(i));
  }
}