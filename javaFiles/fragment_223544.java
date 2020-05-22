// bottom left corner...wherever you want to put it.
float bottomY = 0; 
float leftX = 0;

//width and height of background. This is just an example. By the way, Java 
//convention is for all variable names to start with a lower-case letter, 
//to avoid confusion.
float width = screenWidth;
float height= screenHeight;

//I'm using RATIO like you are, which I think is the reciprocal of how much 
//you want to scale the texture up. By the way, it is convention to make  
//constant variable (static final primitives in Java) names be in all caps.

float uRight = width * RATIO / bg.getWidth();
float vTop= height * RATIO / bg.getHeight();

batch.draw(bg, leftX, bottomY, width, height, 0, 0, uRight, vTop);