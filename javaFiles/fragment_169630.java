PGraphics widg;
PVector widgCoord;
void setup(){
  widgCoord = new PVector(10, 10);
  widg=createGraphics(50, 50);
  drawWidg();
  image(widg,widgCoord.x, widgCoord.y);
}
void draw(){

}
void mouseClicked(){
   if(mouseX > widgCoord.x && mouseX < widgCoord.x + widg.width &&
      mouseY > widgCoord.y && mouseX < widgCoord.y + widg.height){  
    println("clicked!");
  }
}


void drawWidg(){
  widg.beginDraw();
  widg.background(255,0,0);
  widg.endDraw();
}