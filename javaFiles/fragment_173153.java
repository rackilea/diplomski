public class Chunk
{
   private int xPosition;
   private int yPosition;

   private Tile[][] staticTiles;
   private ArrayList<Tile> dynamicTiles;

   ...

   public boolean isInRenderRange()
   {
       ... 
   }

   public boolean isInUpdateRange()
   {
       ...
   }

   ...
}