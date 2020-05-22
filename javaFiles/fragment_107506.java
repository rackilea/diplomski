Stem myStem;
Circle circles[];
Flower p = new Flower();

float scaleFactor=0.5;


void setup() {


  size(floor(400*scaleFactor), floor(800*scaleFactor));
  myStem = new Stem(200, 800);
  p = new Flower (0, 0);
  //mpoved this to setup, no need to recreate each frame
  circles = new Circle[6];
  circles[0]  = new Circle(0, -40, 50, 50);
  circles[1]  = new Circle(0, -40, 50, 50);
  circles[2]  = new Circle(0, -40, 50, 50);
  circles[3]  = new Circle(0, -40, 50, 50);
  circles[4]  = new Circle(0, -40, 50, 50);
  circles[5]  = new Circle(0, 0, 50, 50);
  // also smooth only needs to be called once
  // unless ther is a noSmooth() somewhere
  smooth();
}

void draw() {

  float grow = 0;
  //translate(myStem.initalloX, myStem.initalloY);  
  myStem.drawStem();
  //set centre point
  if (frameCount>grow) {

    translate(myStem.initalloX, ((frameCount>250)?myStem.initalloY-      500:myStem.initalloY-(2*frameCount)));


    fill(170, 14, 24); // red
    for (int i = 0; i < circles.length-1; i++) {
      ellipse(circles[i].c1+grow, circles[i].c2+grow, circles[i].c3+grow, circles[i].c4+grow);
      rotate(radians(72));
    }
    fill(14, 17, 170); // blue
    ellipse(circles[5].c1, circles[5].c2, circles[5].c3, circles[5].c4);
    p.grow();
  }

  p.display();
}

class Stem { 
  int initalloX=200;
  int initalloY=800;

  Stem(int tempInitalloX, int tempInitalloY) {
    initalloX = tempInitalloX;
    initalloY = tempInitalloY;
  }

  void drawStem() {
    background(#0DBADB);
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
      noStroke();
    }
    //stem2
    if (frameCount>151) {
      //  noStroke();
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
  float c3 = 50;
  float c4 = 50;

  Circle(int tc1, int tc2, float tc3, float tc4) {
    c1 = tc1;
    c2 = tc2;
    c3 = tc3;
    c4 = tc4;
  }
}






class Flower {


  float centerX;
  float centerY;
  float posX;
  float posY;
  float maxSize = 51;
  float maxFactor = 40;
  float sizes = 0;
  float factor = 0;
  float speed = 0.17;

  Flower() {
  }
  Flower(float _centerX, float _centerY)
  {
    centerX = _centerX;
    centerY = _centerY;
  }

  void setCenter(float x, float y)
  {
    centerX = x;
    centerY = y;
  }

  void display()
  {
    for (int i = -18; i < 360; i+=72)
    {
       posX = centerX + cos(radians(i)) * factor;
       posY = centerY + sin(radians(i)) * factor;
      noStroke();
      fill(14, 170, 170 ); // blue
      ellipse(posX, posY, sizes, sizes);
    }
    fill(145, 170, 170);

    ellipse(centerX, centerY, sizes , sizes );
  }


  void grow()
  {
    factor = (factor < maxFactor )?  factor + speed: maxFactor;
    sizes = (sizes < maxSize )?  sizes + speed*1.3 : maxSize;

  }
}// end of Flower