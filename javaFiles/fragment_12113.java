public class Sprite
{
   BufferedImage image;
   float x, y, w, h;

   public void draw(Graphics g)
   {
      g.drawImage(image, (int)x, (int)y, (int)(x+w), (int)(y+h), 0, 0, image.getWidth(), image.getHeight(), null);
   }
}