String[] args = {"MyPapplet "};
MyPapplet mp = new MyPapplet ();
PApplet.runSketch(args, mp);

public class MyPapplet extends PApplet {

  public void settings() {
    size(200, 100);
  }
  public void draw() {
    background(255);
    fill(0);
    ellipse(100, 50, 10, 10);
  }
}