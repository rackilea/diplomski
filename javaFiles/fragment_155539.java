ArrayList balls;
int maxBall = 10;
boolean foundCollision;

void setup() {
  size(1000, 800);
  smooth();
  noStroke();
  ellipseMode(RADIUS);

  // Create an empty ArrayList
  balls = new ArrayList();


  float radius = 100;

  balls.add(new Ball(random(100, width-100), random(100, height-100), radius, color(0, 255, 100) ));

  int counter = 0;
  while (balls.size() < maxBall) { 
    foundCollision = false;
    Ball ball = new Ball(random(100, width-100), random(100, height-100), radius, color(0, 255, 100) );


    for (int i = 0; i < balls.size(); i++) {
      Ball currentBall = (Ball) balls.get(i);
      float distance = checkCollision(currentBall.getX(), currentBall.getY(), radius, ball.getX(), ball.getY(), radius);
      if (distance < 200) {
        foundCollision = true;
        counter = counter+1;
        println("COllision: " + counter);
        break;
      }
      distance = 0;
    }
    if (!foundCollision) {
      balls.add(ball);
    }

  }
  println("Total COllision counter: " + counter);
}


void draw() {
  background(0, 0);

  for (int i = balls.size()-1; i >= 0; i--) {
    Ball ball = (Ball) balls.get(i);

    ball.display();
  }
}

class Ball {

  float x;
  float y;
  float r;
  color colorID;


  Ball(float tempX, float tempY, float tempW, color tempColor) {
    x = tempX;
    y = tempY;
    r = tempW;
    colorID = tempColor;
  }


  void display()
  {
    fill (colorID);
    ellipseMode(RADIUS);
    ellipse(x, y, r, r);
  }

  float getX() { 
    return x;
  }
  float getY() { 
    return y;
  }
}

// Check the collision

float checkCollision(float x1, float y1, float r1, float x2, float y2, float r2) { 
  return dist(x1, y1, r1, x2, y2, r2);
}