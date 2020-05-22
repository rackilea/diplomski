public enum ActionMode{  MovingBall, Shooting, Waiting, Etc }

public void act() 
{
        // Steps for calculating the launch speed and angle
        ProjectileWorld myWorld = (ProjectileWorld) getWorld();
        double shotStrength = myWorld.getSpeedValue();
        double shotAngle = myWorld.getAngleValue();
        // Checks to see if the space key is pressed, if it is, the projectile is fired
        String key = Greenfoot.getKey();  
        if ("space".equals(key)){
            mode = ActionMode.MovingBall;
        }
        while(mode==ActionMode.MovingBall){

            //xSpeed and ySpeed changed as requirements say
            xSpeed = (int)(shotStrength*Math.cos(shotAngle));
            ySpeed = -(int)(shotStrength*Math.sin(shotAngle));
            actualX += xSpeed;
            actualY += ySpeed;
            setLocation ((int) actualX, (int) actualY);
            if( ballHasFinishedMoving(actualX, actualY) ){
                 mode==ActionMode.Waiting;
            }
        }
        ...
}
private boolean ballHasFinishedMoving( int actualX, int actualY ){
       logic to determine if ball has finished.
}