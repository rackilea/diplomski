float r = 0;
float g = 0;
float b = 0;

float deltaR = 1;
float deltaG = 2;
float deltaB = 4;

void setup(){
  size(500, 500);
  background(255);
}

void draw(){

  r += deltaR;
  g += deltaG;
  b += deltaB;

  if(r < 0 || r > 255){
    deltaR *= -1;
    r = constrain(r, 0, 255);
  }

  if(g < 0 || g > 255){
   deltaG *= -1;
   g = constrain(g, 0, 255);
  }

  if(b < 0 || b > 255){
    deltaB *= -1;
    b = constrain(b, 0, 255);
  }

  fill(r, g, b);
  ellipse(mouseX, mouseY, 20, 20);
}