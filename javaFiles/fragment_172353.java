public static double lengthdir_x(int len, int dir)
{
    //don't cast here to int!!!!
    return len * Math.cos(Math.toRadians(dir - 90));
}


public class Bullet extends GameObject
{
    private double x;
    private double y;
    private int speed = 2;
    private int direction;
    private int length = 70;

    public Bullet(double x, double y, int direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction; //Set the direction.
    }

    public void update(Game game, GameController gc, float dt)
    {
        x += GameController.lengthdir_x(speed, direction);
        y += GameController.lengthdir_y(speed, direction);
    }

    public void render(Game game, Renderer r)
    {
        //Draw the bullet with the tail behind it.
        r.drawLine((int)Math.round(x), (int)Math.round(y), x + GameController.lengthdir_x(length, direction - 180), y + GameController.lengthdir_y(length, direction - 180), color);

        r.drawText("Dir: " + direction, (int)x + 50, (int)y + 20, 0xff0077ff); //Draws the players angle.
    }
}