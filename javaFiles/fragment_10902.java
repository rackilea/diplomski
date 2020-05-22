while (board[row][column] != "-") {

    if (board[row][column] == "-") {
        board[row][column] = turn();
    } else {
        row = computerMove.nextInt(3);
        column = computerMove.nextInt(3);
        board[row][column] = turn();
    }

}