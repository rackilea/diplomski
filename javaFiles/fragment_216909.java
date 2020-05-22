float c = 0;

float cChange = 1;

void draw(){

  background(c);

  c += cChange;
  if(c < 0 || c > 255){
    cChange *= -1;
  }
}