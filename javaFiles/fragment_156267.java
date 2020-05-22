public class GObject
{

    private Rectangle bounds;

    public float x, y, hspeed, vspeed;

    private Image image;

    public GObject(Image img, float startx, float starty)
    {
        image = img;
        x = startx;
        y = starty;
        hspeed = vspeed = 0;
        bounds = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }

    public Rectangle getBounds()
    {
        bounds.x = x;
        bounds.y = y;
        return bounds;
    }

}