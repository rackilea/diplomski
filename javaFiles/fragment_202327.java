PGraphics p;

void setup(){
  size(400,400,P3D);
  p = createGraphics(400,400,P3D);
  smooth();
  stroke(180,90,210);

}

void draw(){
  background(180,90,210);
  p.beginDraw();
  p.background(220, 180, 40,0);
  p.noFill();
  p.stroke(220, 180, 40);
  p.translate(width/2 - (width/2 - mouseX), height/2, 400-mouseY*5);
  p.sphere(100);
  p.endDraw();
  pushMatrix();
  translate(width/2, height/2, -200);
  rotateY(radians(frameCount));
  rotateX(radians(frameCount/2));
  box(100);
  popMatrix();
  image(p,0,0);
}