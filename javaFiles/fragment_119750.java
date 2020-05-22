Player pl;
float x;
float y;
boolean direction;
moveBodyTask(Player b, float x1, float y1, boolean d)
{
    pl = b;
    x = x1;
    y = y1;
    direction = d;
}

public void move()
{
    pl.moveTo(x, y);
    if(direction)
        pl.setLinearVelocity(new Vector2(5,0));
    else
        pl.setLinearVelocity(new Vector2(-5,0));

}