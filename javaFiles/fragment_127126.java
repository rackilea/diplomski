boolean alreadyPressed = false;

void draw() {}

void mousePressed() {
  if(!alreadyPressed){
   background(random(255)); 
  }
  alreadyPressed = true;
}