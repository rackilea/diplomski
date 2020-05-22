board[i][j] = temp2;
   board[x][y] = temp;

   //Here, I suppose that the second dimension has always the same size. 
   int[][] clonedBoard = new int[board[0].length][board[1].length];

   for (int t = 0; t < board.length; t++) {
     clonedBoard[t] = board[t].clone();
   }
   breadthBoard.add(clonedBoard);