public class Block {
   private int x,y;
   public Block(int x, int y) {
      this.x = x;
      this.y = y;
   }
   public boolean check(int x, int y) {
      if(this.x == x && this.y == y) {
         return true;
      } else {
         return false;
      }
   }
}