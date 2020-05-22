Sphere sphere = new Sphere();

// you might want these to be in the sphere class
float begin;
float change;
float time;
long start;
float duration;
float destX = 200;

// setup, do this when you want to start the animation
void init(){
  begin = sphere.x;
  change = destX - begin;
  time = 0;
  start = System.currentTimeMillis();
  duration = 1000;
}

// loop code, may also be where you render the sphere
void loop(){
  if (time <= duration){
    sphere.x = easeInOutQuad(time, begin, change, duration);
  }else{
    // animation is over, stop the loop
  }
  time = System.currentTimeMillis() - start;
  sphere.render();
}

float easeInOutQuad (float t, float b, float c, float d) {
  if ((t/=d/2) < 1) return c/2*t*t + b;
  return -c/2 * ((--t)*(t-2) - 1) + b;
}

class Sphere{
  float x = 0;
  void render(){
    ellipse(x, 100, 10, 10);
  } 
}