public static void removeSudoku(int[][] sudoku) {
    Random rand = new Random();
    int[] cols = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[] rows = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    //We need to choose an index for each number 0-8 inclusive.
    for (int i=0;i<9;i++) {

      //get a random index on the column array for i
      int randomInt = rand.nextInt(9);
      //In case this random index is already populated - 
      //rand again until an empty spot is available.
      while (cols[randomInt]!=-1) {
        randomInt = rand.nextInt(9);
      }
      cols[randomInt] = i;

      //Same thing for the rows - get a random index in the 
      //array for i, rand again if needed.
      randomInt = rand.nextInt(9);
      while (rows[randomInt]!=-1) {
        randomInt = rand.nextInt(9);
      }
      rows[randomInt] = i;
    }

    //Now that we have the two arrays filled in with a random
    //permutation of ints 0-8, we can use it to remove the 
    //elements from the sudoku.
    for (int i=0;i<9;i++) {
      sudoku[rows[i]][cols[i]] = 0;
    }
  }

  //Just for printout
  public static void printSoduku(int[][] sudoku) {
    for (int i=0;i<9;i++) {
      for(int j=0;j<9;j++) {
        System.out.print(sudoku[i][j]+" ");
        if (j==2 || j==5) {
          System.out.print("|");
        }
      }
      System.out.println();
      if (i==2 || i==5) {
        System.out.println("-------------------");
      } 
    }
  }

  public static void main(String[] args) throws IOException {

    int[][] soduku = new int[][] {{1,2,3,4,5,6,7,8,9},
    {4,5,6,7,8,9,1,2,3},{7,8,9,1,2,3,4,5,6},
    {2,3,4,5,6,7,8,9,1},{5,6,7,8,9,1,2,3,4},
    {8,9,1,2,3,4,5,6,7},{3,4,5,6,7,8,9,1,2},
    {6,7,8,9,1,2,3,4,5},{9,1,2,3,4,5,6,7,8}};
    printSudoku(sudoku);
    removeSudoku(sudoku);
    System.out.println();
    printSudoku (sudoku);
  }