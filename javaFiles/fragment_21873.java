for (int r = 0; r < board.length; r++) {
        System.arraycopy(newboard[r], 0, board[r], 0, board[r].length);
        // Replaces:
        //for (int c = 0; c < board[0].length; c++) {
        //    board[r][c] = newboard[r][c];
        //}
    }