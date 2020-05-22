public class room {

   int length, width;
   int[][] steps;

   public room(int tilesLong, int tilesWide) {
       length = tilesLong + 2;
       width = tilesWide + 2;
       steps = new int[width][length];
   }

   private int getSteps(int tileX, int tileY, int step) {
       this.steps[tileX][tileY] = step;
       return steps[tileX][tileY];
   }

   public void steppedOn(int tileX, int tileY) {
       System.out.println(steps[tileX][tileY] + 1);
   }
}