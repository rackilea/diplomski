public class Solider {

float walkingTime = 0;

  int xpos ;
 int ypos ;
 int xspeed;

public Solider(int xpos,int ypos,int xspeed){

this.xpos = xpos;
this.ypos = ypos;
this.xspeed = xspeed;//movementPerSecond in the x axis for example -3
}

//deltaTime is the time elapsed in milliseconds
public void update(float deltaTime){


xpos += xspeed * (deltaTime / 1000.0);
walkingTime += deltaTime ;
}