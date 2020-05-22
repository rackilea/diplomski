static void Solve(int move_number, int x, int y) {
    board[x][y] = move_number;

    if (DONE) {
       PRINT;
    } else {
        for (int i = 0; i < 8; i++) {
           ATTEMPT_MOVE(i); // now makes more sense!
        }
    }

    board[x][y] = -1; // must undo assignment in first line!
}