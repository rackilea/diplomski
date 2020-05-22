public void paintComponent(Graphics g) {

int w = getWidth();  // Get height and width
int h = getHeight();

// Graphics naar 2d
Graphics2D g2 = (Graphics2D)g;
g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

//... Paint background
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, w, h);
g2.setColor(Color.BLACK);

g2.drawRect(0, 0, w-1, h-1);  // Draw border

Point[] points = pointSpecs[faceValue-1];
for (Point point : points) {
  drawSpot(g2, w*point.x, h*point.y);
}