import processing.video.*;

PGraphics gfx;
Capture video;
int w = 640;
int h = 480;
void setup() {
  size(w, h);
  video = new Capture(this, w, h,30);
  video.start();
  gfx = createGraphics(w, h);
  gfx.beginDraw();
  gfx.background(0);
  gfx.endDraw();
//  println(Capture.list());
}
void draw(){
  image(video,0,0);
  blend(gfx,0,0,w,h,0,0,w,h,SCREEN);//blend the rendered graphics on top of the video using SCREEN mode
  //draw your awesome optical flow graphics here
  gfx.beginDraw();
  gfx.fill(0,10);//same as easyFade() draw transparent bg
  gfx.rect(0,0,width,height);
  gfx.fill(255);
  gfx.ellipse(mouseX,mouseY,10,10);
  gfx.endDraw();
}
void captureEvent(Capture c) {
  c.read();
}