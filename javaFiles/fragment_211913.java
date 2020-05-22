boolean[] isWinning = new boolean[x+1];
for (int state = 0; state <= x; ++state) {
    isWinning[state] = false;
    for (int i = 1; i*i <= state; ++i) {
        int perfectSquare = i*i;
        if (!isWinning[state - perfectSquare]) {
            isWinning[state] = true;
            break;
        }
    }
}