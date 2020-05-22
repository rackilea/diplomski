int shapeSize = 150;
float q = 0;

void setup() {
  size(500, 500);
  smooth();
  noStroke();
  background(0);
}

void draw() {

  noStroke();
  fill( 100, 15);  //builds up low-opacity layers over object
  rect(0, 0, width, height);

  //pushMatrix();
  rectMode(CENTER);  //TOGGLE ON AND OFF TO SEE THE ISSUE
  translate(width/2, height/2);
  rotate(q);
  noStroke();
  fill(255,255);
  rect(0,0, shapeSize,shapeSize);
  q += 0.02;
  //popMatrix();  //Tried toggling push and popMatrix -- no luck
}