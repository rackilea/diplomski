public void paintComponent(Graphics g) {
  // super.paintComponent(g);  // *** commented
  Graphics2D g2d = (Graphics2D) g;
  Color color1 = new Color(226, 218, 145);
  Color color2 = color1.brighter();
  int w = getWidth();
  int h = getHeight();
  GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
  g2d.setPaint(gp);
  g2d.fillRect(0, 0, w, h);
  super.paintComponent(g); // *** added
}