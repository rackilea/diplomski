PGraphics pg;
PGraphics pdf;

boolean usePdf = false;

void setup() {
  size(100, 100);
  pg = createGraphics(width, height);
  pdf = //whatever
}

void draw(){
   if(usePdf){
      display(pdf);
   }
   else{
      display(pg);
      image(pg, 0, 0);
   }
}

void display(PGraphics g) {
  g.beginDraw();
  g.background(100);
  g.stroke(255);
  g.line(20, 20, mouseX, mouseY);
  g.endDraw();
}