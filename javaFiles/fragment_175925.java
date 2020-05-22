void setup(){
  size(500, 500);
  colorMode(HSB, 255);
  background(255);
}

void draw(){
  fill(0, 255, 200, 100);
  ellipse(mouseX, mouseY, 20, 20);
}