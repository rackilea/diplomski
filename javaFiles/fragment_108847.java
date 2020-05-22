boolean upPressed = false;
boolean downPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;

float circleX = 50;
float circleY = 50;

void draw() {
  background(200);  

  if (upPressed) {
    circleY--;
  }

  if (downPressed) {
    circleY++;
  }

  if (leftPressed) {
    circleX--;
  }

  if (rightPressed) {
    circleX++;
  }

  ellipse(circleX, circleY, 20, 20);
}

void keyPressed() {
  if (keyCode == UP) {
    upPressed = true;
  }
  else if (keyCode == DOWN) {
    downPressed = true;
  }
  else if (keyCode == LEFT) {
    leftPressed = true;
  }
  else if (keyCode == RIGHT) {
    rightPressed = true;
  }
}

void keyReleased() {
  if (keyCode == UP) {
    upPressed = false;
  }
  else if (keyCode == DOWN) {
    downPressed = false;
  }
  else if (keyCode == LEFT) {
    leftPressed = false;
  }
  else if (keyCode == RIGHT) {
    rightPressed = false;
  }
}