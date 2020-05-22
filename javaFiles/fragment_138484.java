public static Boolean hasEmptySpot(char[][] board){
   //loop and check if there is empty space 
    for (int i = 0; i< board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] != 'O' && board[i][j] != 'X') {
                return true;
            }
        }
    }
    return false;
}

//New code 
while(hasEmptySpot(board) || !winner(board)){
          //Your code for the game here
     ....
    }