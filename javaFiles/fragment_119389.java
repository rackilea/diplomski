public void move(int some_angle){
    position.x = position.x + (int) (Math.sin(Math.toRadians(some_angle)) * speed);
    position.y = position.y + (int) (Math.cos(Math.toRadians(some_angle)) * speed);
}

public void moveForward()
{
    move(angle);
}

public void strafeLeft()
{
    move(angle+90);
}

public void strafeRight()
{
    move(angle-90);
}

public void moveBackwards()
{
    move(angle+180);
}