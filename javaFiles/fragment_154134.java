int basex = 300;   // midpoint of the circle
int basey = 400;
int radius = 100;  // radius
int x;
int y;
float angle = 0;  // Angles in radians, NOT degrees!

public void run() {
  while(true) {
    angle += 0.01;
    x  = (int)(basex + radius*Math.cos(angle));
    y  = (int)(basey - radius*Math.sin(angle));
    repaint();
    try {
        Thread.sleep(50);
    } catch (InterruptedException ex) {}
  }
}