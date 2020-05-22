private final static int[][][] TRIPLES = new int[][][] {
    { {0, 0}, {0, 1}, {0, 2} },
    { {1, 0}, {1, 1}, {1, 2} },
    { {2, 0}, {2, 1}, {2, 2} },
    { {0, 0}, {1, 0}, {2, 0} },
    { {0, 1}, {1, 1}, {2, 1} },
    { {0, 2}, {1, 2}, {2, 2} },
    { {0, 0}, {1, 1}, {2, 2} },
    { {0, 2}, {1, 1}, {2, 0} },
};

YourConsultant.GameState gameState() {

    for (int i = 0; i < TRIPLES.length; i++) {
        char c = areTheSame(
            board[TRIPLES[i][0][0]][TRIPLES[i][0][1]],
            board[TRIPLES[i][1][0]][TRIPLES[i][1][1]],
            board[TRIPLES[i][2][0]][TRIPLES[i][2][1]]
        );
        if (c == 'x') {
            return YourConsultant.GameState.WON_BY_X;
        } else if (c == 'o') {
            return YourConsultant.GameState.WON_BY_O;
        }
    }

    return YourConsultant.GameState.NO_WINNER;
}