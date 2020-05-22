PVector[] destinations = {
  new PVector(10,10),
  new PVector(90,10),
  new PVector(90,90),
  new PVector(10,90)
};

float traversal = 0.0;

void setup(){

}
void draw(){
  background(255);

  //draw destinations
  for(PVector d : destinations){
    ellipse(d.x,d.y,9,9);
  }

  //calculate traversal
  PVector traversed = traversePoints(destinations,0.01);
  //draw traversal
  ellipse(traversed.x,traversed.y,3,3);
}

PVector traversePoints(PVector[] destinations,float speed){
  if(speed < 0){
    speed = 0.05;
  }
  //increment full path traversal  (the higher the increment, the faster the move)
  traversal += speed;
  //loop back to 0 when fully traversed 
  if(traversal > destinations.length) traversal = 0.0;
  //compute the current point index
  int pointIndex = (int)traversal;
  //compute the local traversal (0.0 -> 1.0 = 0% to 100% in between two points: current and next)
  float pointT = traversal - pointIndex;
  //compute the next current point index
  int pointIndexNext = (pointIndex + 1) % destinations.length; 

  //interpolate between current and next points using above local traversal, offsetting by the last mainHingeition)
  return PVector.lerp(destinations[pointIndex],
                            destinations[pointIndexNext],
                            pointT);
}