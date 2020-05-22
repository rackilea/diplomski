for (int k = 1; k <= Chut; k++) {
    int RanNum = ran.nextInt(board.length);
    if (board[RanNum].addSpaces == 0) // uninitialized
        this.board[RanNum] = new Cell(-10);
    else
        k--;
}