static int ROWS = 10;
static  int COLS = 3;

public static void main (String[] args)
{
  Scanner input = new Scanner (System.in);

  System.out.println("1 for first class \n2 for economy \n3 to view seating chart \n0 to exit");

  boolean[][] grid = new boolean[ROWS][COLS];

  int menu = input.nextInt();

  if (menu < 3) {
      System.out.println("Which seat would you like " + (menu == 1 ? "(1-9)": "(10-30)")+": ");
      int selection = input.nextInt();
      if(((menu == 1 && selection <= 9 && selection >= 1) || (menu == 2 && selection <= 30 && selection >= 10))){
        grid[selection / 3][selection % 3] = true;
      }
  } else if (menu == 3) {

    for(int r = 0 ; r < ROWS; r++){
      for(int c =0; c < COLS ;c++){
        System.out.print(grid[r][c] ? 'x' : 'o');
      }
      System.out.println();
    }
  }
}