import processing.opengl.*;
import javax.media.opengl.*;

float direction = 0;//angle in degrees
float speed = 0;//radius
float xPos,yPos;

void setup() {
  size(600, 500, OPENGL);
}

void keyPressed(){
  if(key == 'w') speed += 1;
  if(key == 'a') direction -= 10;
  if(key == 'd') direction += 10;
  if(key == 's') speed -= 1;
  if(speed > 10) speed = 10;
  if(speed < 0) speed = 0;
  println("direction: " + direction + " speed: " + speed);
}

void draw() {
  //update
  xPos += cos(radians(direction)) * speed;
  yPos += sin(radians(direction)) * speed;
  //draw
  background(255);
  PGraphicsOpenGL pgl = (PGraphicsOpenGL) g; 
  GL gl = pgl.beginGL();
  gl.glTranslatef(width * .5,height * .5,0);//start from center, not top left

  gl.glPushMatrix();
  {//enter local/relative
    gl.glTranslatef(xPos,yPos,0);
    gl.glRotatef(direction-90,0,0,1);
    gl.glColor3f(.75, 0, 0);
    gl.glBegin(GL.GL_TRIANGLES);
    gl.glVertex2i(0, 10);
    gl.glVertex2i(-10, -10);
    gl.glVertex2i(10, -10);
    gl.glEnd();
  }//exit local, back to global/absolute coords
  gl.glPopMatrix();

  pgl.endGL();
}