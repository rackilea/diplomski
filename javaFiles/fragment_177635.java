public class MazePosDemo  {
   private static final int[][] MAZE_GRID = new int[][] {

   //mega maze grid goes here...

   };

   private static final MazePosition MAZE_HOLDER = new MazePosition(MAZE_GRID);

   public static final void main(String[] ignored)  {
      MazePosition pos = new MazePosition(0, 0);
      System.out.println("start: " + pos);

      pos = pos.getNeighbor(Direction.RIGHT);
      System.out.println("right: " + pos);

      pos = pos.getNeighbor(Direction.RIGHT);
      System.out.println("right: " + pos);

      pos = pos.getNeighbor(Direction.DOWN);
      System.out.println("down:  " + pos);

      pos = pos.getNeighbor(Direction.DOWN);
      System.out.println("down:  " + pos);

      pos = pos.getNeighbor(Direction.RIGHT);
      System.out.println("right: " + pos);

      pos = pos.getNeighbor(Direction.DOWN);
      System.out.println("down:  " + pos);

      pos = pos.getNeighbor(Direction.LEFT);
      System.out.println("left:  " + pos);

      pos = pos.getNeighbor(Direction.UP);
      System.out.println("up:    " + pos);

      pos = pos.getNeighbor(Direction.UP);
      System.out.println("up:    " + pos);

      System.out.println(pos.getNineByNine());
   }

}