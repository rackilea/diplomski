/**
 * Checks the board to see if there is a winner
 *
 * @param board The board to check
 * @return Returns (1 if player1 wins) (-1 if player2 wins) and (0 if no one won)
 */
public static int checkWinner (int[][] board) {
    int row, col, diagDown=0, diagUp=0;
    for(int i=0; i<board[0].length; i++) { 
        row=0;
        col=0;
        for(int j=0; j<board.length; j++) {
            row+=board[i][j];
            col+=board[j][i];
        }
        //Player1 wins!
        if(row==board.length||col==board.length)
            return 1;
        //Player2 wins!
        if(row==-1*board.length||col==-1*board.length)
            return -1;

        diagDown+=board[i][i];
        diagUp+=board[i][board.length-1-i];
    }
    //Player1 wins!
    if(diagUp==board.length||diagDown==board.length)
        return 1;
    //Player2 wins!
    if(diagUp==-1*board.length||diagDown==-1*board.length)
        return -1;
    //No winner
    return 0;
}