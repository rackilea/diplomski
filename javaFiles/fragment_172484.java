public class ProjectileEquation
{
public float gravity;
public Vector2 startVelocity = new Vector2();
public Vector2 startPoint = new Vector2();

public ProjectileEquation()
{   }

public float getX(float t)
{
    return startVelocity.x*t + startPoint.x;
}

public float getY(float t)
{
    return 0.5f*gravity*t*t + startVelocity.y*t + startPoint.y;
}
}