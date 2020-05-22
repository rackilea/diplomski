void setup() {
  size(300, 200);
}
void draw() {
  background(0);
  stroke(0);
  beginShape(TRIANGLE_STRIP);

  vertex(0, 200);
  vertex(0, 0);
  vertex(50, 200);
  vertex(100, 0);
  vertex(150, 200);
  vertex(200, 0);
  vertex(250, 200);
  vertex(300, 0);
  vertex(300, 200);

  endShape();
}