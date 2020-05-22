public static void computerMove() {
    Random computerMove = new Random();
    row = computerMove.nextInt(3);
    column = computerMove.nextInt(3);
    while (board[row][column] != "-") {
        row = computerMove.nextInt(3);
        column = computerMove.nextInt(3);
    }
    board[row][column] = turn();
}