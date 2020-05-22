void generate(int r, int c) {
        // find next empty spot in column-major order
        while (c < N && board[r][c] != EMPTY) {
            if (++r == M) {
                r = 0;
                c++;
            }
        }
        if (c == N) { // we're done!
            count++;
            printBoard();
            return;
        }
        if (c < N - 1) {
            board[r][c] = '<';
            board[r][c+1] = '>';
            generate(r, c);
            board[r][c] = EMPTY;
            board[r][c+1] = EMPTY;
        }
        if (r < M - 1 && board[r+1][c] == EMPTY) {
            board[r][c] = 'A';
            board[r+1][c] = 'V';
            generate(r, c);
            board[r][c] = EMPTY;
            board[r+1][c] = EMPTY;
        }
    }