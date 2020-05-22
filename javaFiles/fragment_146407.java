ArrayList<MovingPoint> points = new ArrayList<MovingPoint>();
float circleDiameter = 200;

void setup(){

  size(500, 500);

  for(int i = 0; i < 100; i++){
    points.add(new MovingPoint());
  }
}


void draw(){

  background(0);

  noFill();
  stroke(255, 0, 0);
  ellipse(mouseX, mouseY, circleDiameter, circleDiameter);

  fill(255);
  stroke(255);

  MovingPoint previousPoint = null;

  for(MovingPoint mp : points){

    mp.draw();

    if(previousPoint != null){
      line(previousPoint.current.x, previousPoint.current.y, mp.current.x, mp.current.y);
    }

    previousPoint = mp;
  }
}

class MovingPoint{
  PVector original;
  PVector current;

  public MovingPoint(){
    original = new PVector(random(width), random(height));
    current = original.copy();
  }

  void draw(){

    if(dist(current.x, current.y, mouseX, mouseY) < circleDiameter/2){
     //inside circle, reset position
     current = original.copy();
    }
    else{
      //outside circle, move randomly
      current.x += random(-5, 5);
      current.y += random(-5, 5);
    }

    ellipse(current.x, current.y, 10, 10);
  }
}