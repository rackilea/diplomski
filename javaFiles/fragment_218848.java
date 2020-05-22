int rad = 100;

void setup() {
  size(400, 400);
}

void draw() {
  background(255);
  ellipse(width/2, height/2, rad*2, rad*2);

  // Using the mouse to mimic the position of the joystick
  float theta = atan2(mouseY-height/2, mouseX-width/2);

  // Get the new position
  float x = width/2+cos(theta)*rad;
  float y = height/2+sin(theta)*rad;

  // Show the new position
  ellipse(x, y, 30, 30);
}