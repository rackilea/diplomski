float cx,cy,px,py;//current x,y, previous x,y
float len = 15;

void setup(){
  size(200,200);
  background(255);
}
void draw(){
  //update position - chase mouse with a bit of easing
  cx -= (cx - mouseX) * .035;
  cy -= (cy - mouseY) * .035;
  //find direction of movement based on the current position
  float angle = atan2(cy-py,cx-px);
  //store previous position
  px = cx;
  py = cy;
  //render
  fill(255,10);noStroke();
  rect(0,0,width,height);
  fill(127,32);stroke(0);
  pushMatrix();
  translate(cx,cy);
    pushMatrix();
    rotate(angle);
    triangle(len,0,-len,-len,-len,len);
    line(0,0,len,0);
    popMatrix();
  popMatrix();
}