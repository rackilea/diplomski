static void Solve(int move_number, int x, int y) {
    board[x][y] = move_number;

    if (DONE) {
       PRINT;
    } else {
        for (int i = 0; i < 8; i++) {
            for (int c = 0; c < 8; c++) {
                ATTEMPT_MOVE(i, c); // doesn't make sense!!!
            }
        }
        board[x][y] = -1; // this doesn't belong here!!!
    }
}