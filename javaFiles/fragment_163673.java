Date date = new Date();
int[][] board = {{0, 0, 5, 9, 7, 1, 8, 4, 6},
                        {0, 7, 1, 2, 8, 6, 9, 3, 5},
                        {0, 9, 6, 4, 3, 5, 2, 7, 1},
                        {0, 6, 8, 7, 4, 9, 5, 2, 3},
                        {0, 4, 9, 5, 2, 3, 1, 6, 8},
                        {0, 5, 2, 1, 6, 8, 4, 9, 7},
                        {0, 2, 4, 8, 1, 7, 3, 5, 9},
                        {0, 1, 3, 6, 5, 2, 7, 8, 4},
                        {0, 8, 7, 3, 9, 4, 6, 1, 2}}; 

StringBuilder builder = new StringBuilder();
for(int i = 0; i < board.length; i++)//for each row
{
   for(int j = 0; j < board.length; j++)//for each column
   {
      builder.append(board[i][j]+"");//append to the output string
      if(j < board.length - 1)//if this is not the last row element
         builder.append(",");//then add comma (if you don't like commas you can use spaces)
   }
   builder.append("\n");//append new line at the end of the row
}
BufferedWriter writer = new BufferedWriter(new FileWriter("/c:/sudoku" + date + ".txt"));
writer.write(builder.toString());//save the string representation of the board
writer.close();