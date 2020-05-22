public class Bullet {
  // speed is in units/second
  // angle is in radians
  double x;
  double y;
  double sv;
  double sh;
  public Bullet(double x, double y, double angle, double speed) {
    this.x = x;
    this.y = y;
    sv = Math.sin(angle)*speed;
    sh = Math.cos(angle)*speed;
    last_updated = System.currentTimeMillis();
  }

  long last_updated;

  public void update() {
    long time_elapsed = System.currentTimeMillis() - last_updated;
    last_updated = System.currentTimeMillis(); 
    this.x += this.hs*(this.time_elapsed/1000)
    this.y += this.vs*(this.time_elapsed/1000)
  }
}