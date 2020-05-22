//n number of points
int num = 4;
//arraylist to store the picked values
ArrayList<cntrlPoint> pt;

//import the geomerative library
import geomerative.*;



//string
String str = "(O_o)/ Oooh";

FloatList X;
FloatList Y;
FloatList SUM;

RClass rc;

void setup() {
  size(1000, 1000, P2D);
  pt = new ArrayList<cntrlPoint>();
  //pick a number of points with random positions
  for (int i=0; i<=num; i++) {
    float x = random(0, width);
    float y = random(0, height);
    pt.add(new cntrlPoint(x, y));
  }

  RG.init(this);
  rc = new RClass();   

  X = new FloatList();
  Y = new FloatList();  
  SUM = new FloatList();
}

void draw() {
  background(255);
  noFill();
  strokeWeight(2);
  drwCntrlPoints();
  drwCurve();
  gtArcLength();
  fill(0,255,0);
  rc.crtPoly(pt);
  rc.drwText();
}

void drwCntrlPoints() {
  //draw points
  beginShape();
  for (int i=0; i<=num; i++) {
    vertex(pt.get(i).x, pt.get(i).y);
  }
  endShape();

  for (int i=0; i<=num; i++) {
    ellipse(pt.get(i).x, pt.get(i).y, 10, 10);
  }
}

void drwCurve() {
  //draw curve
  float curveDetail = 0.01;
  float nfac = 1;
  for (int i=0; i<num; i++) {
    nfac *= (i+1);
  }
  int arcIndex = 0;
  strokeWeight(2);
  beginShape();
  for (float t=0; t<=1; t+=curveDetail) {
    float x = 0;
    float y = 0;
    arcIndex++;
    for (int i=0; i<=num; i++) {

      float coef = 1;
      float kfac = 1;
      float k_nfac = 1;
      for (int k=i; k>0; k--) {
        kfac *= k;
      }
      for (int k=(num-i); k>0; k--) {
        k_nfac *= k;
      }

      coef = nfac/(kfac*k_nfac);

      x += coef*(pow((1-t), num-i)*pow(t, i)*pt.get(i).x);
      y += coef*(pow((1-t), num-i)*pow(t, i)*pt.get(i).y);
    }
    vertex(x, y);
    X.set(arcIndex, x);
    Y.set(arcIndex, y);
  }
  endShape();
}

void gtArcLength() {
  //get arclength by pulling points from a floatlist
  int numberOfDivisions = X.size()-2;
  int maxPoint = numberOfDivisions+1;

  float sum = 0;

  float prevPointX = X.get(0);
  float prevPointY = Y.get(0);

  for (int i=1; i<=maxPoint; i++) {
    float pointX = X.get(i);
    float pointY = Y.get(i);
    sum += dist(pointX, pointY, prevPointX, prevPointY);
    SUM.set(i-1, sum);
    prevPointX = pointX;
    prevPointY = pointY;
  }
}

//*******factorial
int fact(int fa){
  if(fa==1){
    return 1;
  }
  if(fa==0){
    return 1;
  }
  else{
    return fa*fact(fa-1);
  }
}
//********************

int IndexOfLargestValueSmallerThan(float _targetArcLength) {
  int index = 0;
  for (int i=0; i<SUM.size()-1; i++) {
    if (SUM.get(i)<=_targetArcLength) {
      index = i;
    }
  }
  return index;
}

void mouseDragged() {
  int which = -1;
  if ((mouseX<width)&&(mouseX>0)&&(mouseY<height)&&(mouseY>0)) {
    for (int i=0; i<=num; i++) {
      if (dist(mouseX, mouseY, pt.get(i).x, pt.get(i).y)<80) {
        which = i;
      }
    }
    if (which>-1) {
      pt.get(which).update(mouseX, mouseY);
    }
  }
}

class RClass {
  //get ttf file
  //create rfont
  RFont fnt;
  //turn rfont to rgroup to get points
  RGroup rg;
  //going to get point in path, so that the characters in the string can be seperated
  RPoint [][]rp;

  //floatlist to store coefficients
  FloatList Cx;
  FloatList Cy;

  RClass() {
    fnt = new RFont("Zapfino.ttf", 100);
    rg = fnt.toGroup(str);
    rp = rg.getPointsInPaths();

    //RCommand.setSegmentAngle(random(0,HALF_PI)); 
    //RCommand.setSegmentator(RCommand.ADAPTATIVE);
    RCommand.setSegmentLength(3); 
    RCommand.setSegmentator(RCommand.UNIFORMLENGTH);

    Cx = new FloatList();
    Cy = new FloatList();
  }

  //**********************************here
  void crtPoly(ArrayList<cntrlPoint> _pt){
    float ptsize = _pt.size();
    for(int j=0; j<ptsize; j++){
      float coefx = 0;
      float coefy = 0;
      float pi = 1;
      float sigx = 0;
      float sigy = 0;
      for(int m=0; m<=j-1; m++){
        pi *= (ptsize-1-m);
      }
      for(int i=0; i<=j; i++){
        sigx += (pow(-1,i+j)*pt.get(i).x)/(fact(i)*fact(j-i));
        sigy += (pow(-1,i+j)*pt.get(i).y)/(fact(i)*fact(j-i));
      }
      coefx = pi*sigx;
      coefy = pi*sigy;
      Cx.set(j,coefx);
      Cy.set(j,coefy);
    }
  }
  //**************************************

  void drwText() {
    float indent = SUM.get(0);  

    beginShape();       
    for (int i=0; i<rp.length; i++) {
      if(i>0){
        beginContour();
      }
      for (int j=0; j<rp[i].length; j++) {

        float t = 0;

        indent = rp[i][j].x+SUM.get(0);

        float targetArcLength = indent;

        int index = IndexOfLargestValueSmallerThan(targetArcLength);

        if (SUM.get(index)==targetArcLength) {
          t = index/(SUM.size()-1);
        } else {
          float lengthBefore = SUM.get(index);
          float lengthAfter = SUM.get(index+1);
          float segmentLength = lengthAfter - lengthBefore;
          float segmentFraction = (targetArcLength - lengthBefore)/segmentLength;
          t = (index+segmentFraction)/(SUM.size()-1);
        }

        //***************************here
        float x = 0;
        float y = 0;
        float vx = 0;
        float vy = 0;

        for(int l=0; l<=num; l++){
          x += Cx.get(l)*pow(t,l);
          y += Cy.get(l)*pow(t,l);
        }

        for(int l=1; l<=num; l++){
          vx += l*Cx.get(l)*pow(t,l-1);
          vy += l*Cy.get(l)*pow(t,l-1);
        }
        //**************************************

        PVector P = new PVector(x, rp[i][j].y+y);

        PVector ldir = new PVector(P.x-x, P.y-y);


        PVector dir = new PVector(vy, -vx); 
        //
        ldir.rotate(dir.heading()+PI/2);

        vertex(x+ldir.x, y+ldir.y);
      }
      if(i>0&&i<rp.length){
        endContour();
      }
    }
    endShape();
  }
}

class cntrlPoint{
  float x,y;

  cntrlPoint(float _x, float _y){
    x = _x;
    y = _y;
  }

  void update(float _newx, float _newy){    
    x = _newx;
    y = _newy;   
  }

}