public class Layer
{
   List<Sprite> sprites;

   public void draw(Graphics g)
   {
      for (Sprite sprite : sprites)
         sprite.draw(g);
   }
}