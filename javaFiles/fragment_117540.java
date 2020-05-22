public static void drawCircles(Graphics g) {
  int radius = 10;
  int x = 0;
  while(x <= 10) {
    int z = radius / 2;
    g.drawOval(100 - z, 100 - z, radius, radius);              
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {

    }
    x++;
    radius = radius + 10;
  }
}