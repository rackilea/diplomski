import processing.awt.PSurfaceAWT;
import processing.awt.PSurfaceAWT.SmoothCanvas;

void setup(){
  size(200, 200);
}

void draw(){
  background(0);

  int x = ( (SmoothCanvas) ((PSurfaceAWT)surface).getNative()).getFrame().getX();
  text("x: " + x , 20, 20);
}