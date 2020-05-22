PFont f;
PFont f2;
void setup(){
  size(600, 300);

  f = createFont("SegoeUI-Semibold-200", 100);
  f2 = createFont("SegoeUI-Semibold-200", 20);

}

String metric = "anystuff";

void draw(){ 
  background(110);


fill(240);
textFont(f);
text(metric, 0, height-20);
float sw = textWidth(metric); //after font is set...

fill(0);
textFont(f2);
text("sufix",sw, height-20); //just use it :)

}