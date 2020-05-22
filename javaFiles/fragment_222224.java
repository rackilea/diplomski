int buttonX = 200;// the x position of the circle 
int buttonY = 200;// the y position of the circle 

ellipse(buttonX, buttonY,100,100);// the button

// if mouseX and mouseY are inside the radius of the 100px diameter button then it is active
if(dist(mouseX, mouseY, buttonX, buttonY) < 50) {
   // the mouse is inside of the circle
}