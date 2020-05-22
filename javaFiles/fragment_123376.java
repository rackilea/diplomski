public class BlockTest {
  public static boolean checkBlock (int col0to2, int row0to2)
  {
    int [] tempArray = new int[9];
    for (int x=0; x<3; x++)
    {
      for (int y=0; y<3;y++)
      {
        int tempVal = board [col0to2+x][row0to2+y];
        if (tempVal < 1 || tempVal > 9) return false;
        if (++tempArray[tempVal - 1] == 2) return false;
      } 
    }
    return true;
  }

  public static int[][] board = new int[9][9];
  public static void main(String[] args) {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        board[i][j] = i*3 + j + 1;
      }
    }
    System.out.println(checkBlock(0,0));
    board[0][0] = 7;
    System.out.println(checkBlock(0,0));
  }
}