public Score calculateScore(int playerWinBalls, int opponentWinBalls) {
    if (playerWinBalls <= 3) {
        return Score.values()[playerWinBalls];
    }
    int winBallsDifference = playerWinBalls - opponentWinBalls;
    if (winBallsDifference <= 0) {
        return Score.Forty;
    }
    if (winBallsDifference == 1) {
        return Score.Advantage;
    }
    return Score.Game;
}