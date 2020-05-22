PShape myshape;

void setup() {
  size(500, 500, P3D);
  myshape = loadShape("test.obj");
}

void draw() {
  background(0);
  translate(width/2, height/2, 100);
  scale(20);
  shape(myshape);
}