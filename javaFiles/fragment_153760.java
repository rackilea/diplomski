public void placeWordHorizontally(char[][] board, String word, int x, int y) {
    for (int i = 0; i < word.length(); i++) {
        if (y + i >= board[x].length) {
             // fail ... edge of board
        } else if (board[x][y + i]) == '*') {
             // fail ... blocked.
        } else {
             board[x][y + i] = word.charAt(i);
        }
    }
}