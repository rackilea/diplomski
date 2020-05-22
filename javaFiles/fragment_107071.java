Graphics2D g2;
double thickness = 2;
Stroke oldStroke = g2.getStroke();
g2.setStroke(new BasicStroke(thickness));
g2.drawRect(x, y, width, height);
g2.setStroke(oldStroke);