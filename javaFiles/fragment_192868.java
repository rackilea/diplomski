PImage bg;
void setup(){
  size(240,240);noStroke();
  bg = loadImage("test.png");
}
void draw(){
  easyFade();
  fill(255);
  ellipse(mouseX,mouseY,10,10);
}
void easyFade()
{
  tint(255,10);
  image(bg,0,0);
}