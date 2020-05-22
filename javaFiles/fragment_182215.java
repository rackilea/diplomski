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
  }
}