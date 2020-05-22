@Override
protected void paintComponent(Graphics g) {
Graphics2D g2 = (Graphics2D) g;
// Creates a two-stops gradient
GradientPaint p;
p = new GradientPaint(0, 0, new Color(0xFFFFFF),
0, getHeight(), new Color(0xC8D2DE));
// Saves the state
Paint oldPaint = g2.getPaint();
// Paints the background
g2.setPaint(p);
g2.fillRect(0, 0, getWidth(), getHeight());
// Restores the state
g2.setPaint(oldPaint);
// Paints borders, text...
super.paintComponent(g);
}
}