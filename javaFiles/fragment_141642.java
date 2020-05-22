void draw() {
  background(220);

  switch (mode) {
    case (0):
      c = color(255, 0, 0, transparency);
      break;
    case (1):
      c = color(0, 255, 0, transparency);
      break;
    case (2):
      c = color(0, 0, 255, transparency);
      break;    
  }

  fill(c); //fill with color
  ellipse(200, 400, 100, 100);
}