public class GameArea extends JPanel
{
    private final Collection<Sprite> sprites; // sprites to draw

    public void paintComponent(Graphics g)
    {
        for(Sprite sprite : sprites)
        {
            sprite.drawOnSurface(g);
        }
    }
}

public class Sprite // no need to extend anything
{
    /* Your other code looks OK */

    public void drawOnSurface(Graphics surface)
    {
        surface.drawImage(image, x, y, getWidth(), getHeight());
    }
}