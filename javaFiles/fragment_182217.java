public class BlueBG extends PApplet {
  int counter = 0;
  public void setup() {
    size(400, 400);
    counter = 0;
  }
  public void draw() {
    background(counter, counter, 255);
    fill(255-counter);
    text(String.valueOf(counter), width*0.5, height*0.5, width, height);
    counter++;
    lala1();
    lala2();
    lala3(this);
  }
  public void lala1() {
    fill(255, 255, 0);
    ellipse(100, 100, 100, 100);
  }
}
public void lala2() {
  fill(255, 0, 255);
  ellipse(150, 150, 100, 100);
}
public void lala3(PApplet p) {
  p.fill(0, 255, 255);
  p.ellipse(200, 200, 100, 100);
}