Stem myStem;

//Circle circles; // double declaration
  Circle circles[]; // keeping the array one only

float scaleFactor=0.5;

void setup() {
  size(floor(400*scaleFactor), floor(800*scaleFactor));
  myStem = new Stem(200,800);

  //mpoved this to setup, no need to recreate each frame
  circles = new Circle[5];
  circles[0]  = new Circle(0, -40, 50, 50);
  circles[1]  = new Circle(0, -40, 50, 50);
  circles[2]  = new Circle(0, -40, 50, 50);
  circles[3]  = new Circle(0, -40, 50, 50);
  circles[4]  = new Circle(0, -40, 50, 50);
  // also smooth only needs to be called once
  // unless ther is a noSmooth() somewhere
  smooth();

}

void draw() {

  // moved this here
  background(#0DBADB);

  for (int i = 0; i < circles.length; i++) {
   ellipse(circles[i].c1, circles[i].c2, circles[i].c3, circles[i].c4);
   // note you may use this instead
   //ellipse(0, -40, 50, 50);
   rotate(radians(72));
  }

  myStem.drawStem();


}



class Stem { 
  int initalloX=200;
  int initalloY=800;

  Stem(int tempInitalloX, int tempInitalloY) {
    initalloX = tempInitalloX;
    initalloY = tempInitalloY;

  }

  void drawStem() {
    //background(#0DBADB); // this was hiding all other draws
    scale(scaleFactor, scaleFactor);
    stroke (12, 149, 11);
    fill (12, 149, 11);
    strokeWeight(10);
    line(initalloX, initalloY, initalloX, ((frameCount>250)?initalloY-500:initalloY-(2*frameCount)));
    //stem1
    if (frameCount>101) {
      noStroke();
      translate(initalloX, initalloY-200);
      scale(min((float)(frameCount-100)/100, 1), min((float)(frameCount-100)/100, 1));
      beginShape();
      vertex(0, 0);
      bezierVertex(-40, -5, -30, -40, -80, -20);
      bezierVertex(-47, -16, -52, 8, 0, 0);
      endShape(CLOSE);
      scale(1/min((float)(frameCount-100)/100, 1), 1/min((float)(frameCount-100)/100, 1));
      translate(-initalloX, -(initalloY-200));
    }
    //stem2
    if (frameCount>151) {
      noStroke();
      translate(initalloX, initalloY-300);
      scale(-min((float)(frameCount-150)/150, 1), min((float)(frameCount-150)/150, 1));
      beginShape();
      vertex(0, 0);
      bezierVertex(-40, -5, -30, -40, -80, -20);
      bezierVertex(-47, -16, -52, 8, 0, 0);
      endShape(CLOSE);
      scale(-1/min((float)(frameCount-150)/150, 1), 1/min((float)(frameCount-150)/150, 1));
      translate(-initalloX, -(initalloY-300));
    }
  }
}

class Circle {

  int c1 = 0;
  int c2 = -40;
  int c3 = 50;
  int c4 = 50;

  Circle(int tc1, int tc2, int tc3, int tc4) {
    c1 = tc1;
    c2 = tc2;
    c3 = tc3;
    c4 = tc4;
  }
 }