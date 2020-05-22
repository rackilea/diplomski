protected void paintComponent(Graphics g) {
  super.paintComponent(g);
  font1 = new Font("Serif", Font.BOLD, 36);
  g.drawImage(background, 0, 0, this);
  g.drawImage(sprite, myX, myY, this);
  g.setColor(Color.yellow);
  int rectCount = 10;
  int height = getHeight() / rectCount;
  int width = 272;
  int x = getWidth() - width;
  for (int i = 0; i < rectCount; i++) {
     int y = i * height;
     g.drawRect(x, y, width, height);
  }
  g.setFont(font1);
  g.drawString(Integer.toString(count), 500, 100);
}