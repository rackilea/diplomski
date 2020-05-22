public class Player
{
     //coordinates of the player 
     private int x, y;

     //horizontal and vertical components of the player's speed.
     private int xSpeed, ySpeed; 

     //call a method similar to this one every time your player updates its position
     public void updatePosition()
     {
          x += xSpeed;
          y += ySpeed;
     }

     //Converts a speed and a direction (much easier to deal with)
     //to an x speed and a y speed (much easier for actually moving) 
     //and sets the player's motion
     public void setSpeedWithDirection(int speed, float direction)
     {
         xSpeed = Math.cos(direction) * speed;
         ySpeed = Math.sin(direction) * speed;
     }
}