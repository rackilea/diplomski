public Board(int[][] layout){
  this();
  for(int i=0; i<layout.length;i++)
   for(int j=0; j<layout[0].length;j++)
      board[i][j] = layout[i][j];
}