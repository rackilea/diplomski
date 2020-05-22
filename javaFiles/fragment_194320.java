public class Board {
    private boolean isOver = false;
    private int turn;
    private int[][] map;
    public final int width, height;
    @Override
    public Board clone() throws CloneNotSupportedException {
      return new Board(isOver, turn, map.clone(), width, height);
    }
    private Board(boolean isOver, int turn, int[][] map, int width, int height) {
      this.isOver = isOver;
      this.turn = turn;
      this.map = map;
      this.width = width;
      this.height = height;
    }
}