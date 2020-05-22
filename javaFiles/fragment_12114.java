public class Scene
{
   List<Layer> layers;

   public void draw(Graphics g)
   {
      for (Layer layer : layers)
         layer.draw(g);
   }
}