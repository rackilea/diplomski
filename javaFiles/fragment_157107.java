protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  // draw image
  if (img != null) {
     g.drawImage(img, X_SHIFT, Y_SHIFT, null);
  }

  // if displayPoint not null, draw the surrounding rectangle
  if (displayPoint != null) {
     g.setColor(RECT_COLOR);
     int x = displayPoint.x - RECT_WIDTH / 2;
     int y = displayPoint.y - RECT_WIDTH / 2;
     int width = RECT_WIDTH;
     int height = RECT_WIDTH;
     g.drawRect(x, y, width, height);
  }
}