PImage img;

void setup() {
  size(300, 200, P3D);
  img = loadImage("test.png");
  textureMode(NORMAL);
}
void draw() {
  background(0);
  stroke(0);
  beginShape(TRIANGLE_STRIP);

  texture(img);
  vertex(0, 200, 0, 1);
  vertex(0, 0, 0, 0);
  vertex(50, 200, .16, 1);
  vertex(100, 0, .33, 0);
  vertex(mouseX, mouseY, .5, 1);
  vertex(200, 0, .66, 0);
  vertex(250, 200, .83, 1);
  vertex(300, 0, 1, 0);
  vertex(300, 200, 1, 1);

  endShape();
}