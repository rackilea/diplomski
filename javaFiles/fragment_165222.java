int cols, rows;
int scl = 20;
int gridsize = 0;

void setup() {
  size(400, 400);
  int w = 400;
  int h = 400;
  cols = w / scl;
  rows = h / scl;
}

void draw() {
  //mouseX, mouseY
  background(255);

  for (int x = 0; x < cols; x++) {
    for (int y = 0; y < rows; y++) {
      int xpos = x*scl;
      int ypos = y*scl;
      stroke(55);
      if(
        (mouseX >= xpos && mouseX <= xpos+scl) &&
        (mouseY >= ypos && mouseY <= ypos+scl)
        ){
        fill(90);
      }else{
        fill(50);
      }

      rect(xpos, ypos, scl, scl);
    }
  }
}