public Board(int[][] board, int x, int y){
    if (board[x][y]!=0)
        throw new IllegalArgumentException("Field (" +x+","+y+") must be free (0).");
    this.board = new int[board.length][board[0].length];
    for (int i = 0; i < this.board.length; i++)
        for (int j = 0; j < this.board[i].length; j++)
            this.board[i][j] = board[i][j];
    this.freeX = x;
    this.freeY = y;
    this.N = board.length;
}