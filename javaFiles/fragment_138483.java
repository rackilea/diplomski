public static Boolean winner(char[][] board){
   //Boolean which is true until there is a empty spot
   boolean occupied = true;
   //loop and check if there is empty space or if its a draw
    for (int i = 0; i< board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //Check if spot is not 'O' or not 'X' => empty 
            if (board[i][j] != 'O' || board[i][j] != 'X') {
                occupied = false;
            }
        }
    }
    if(occupied)
        return false;
   //Check if someone won
    return (board[0][0] == board [0][1] && board[0][0] == board [0][2]) ||
        (board[0][0] == board [1][1] && board[0][0] == board [2][2]) ||
        (board[0][0] == board [1][0] && board[0][0] == board [2][0]) ||
        (board[2][0] == board [2][1] && board[2][0] == board [2][2]) ||
        (board[2][0] == board [1][1] && board[0][0] == board [0][2]) ||
        (board[0][2] == board [1][2] && board[0][2] == board [2][2]) ||
        (board[0][1] == board [1][1] && board[0][1] == board [2][1]) ||
        (board[1][0] == board [1][1] && board[1][0] == board [1][2]);
}