int counter = 0;
public void setup() {
  size(400, 400);
  counter = 0;
}
public void draw() {
  background(255, counter, counter);
  fill(255-counter);
  text(String.valueOf(counter), width*0.5, height*0.5, width, height);
  counter++;
}