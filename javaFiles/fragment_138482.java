public static Boolean winner(char[][] board){
    for (int i = 0; i< board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[i][j] == 'O' || board[i][j] == 'X') {
                return false;
            }
        }
    }