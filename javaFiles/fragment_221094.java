float circleX;
float circleY;

void draw(){
   background(0);
   ellipse(circleX, circlY, 10, 10);
}

void mouseReleased(){
   circleX = mouseX;
   circleY = mouseY;
}