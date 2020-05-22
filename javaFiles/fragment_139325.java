for (int j = 0; j < 1; j++) {
    do {
        temp = (int) (Math.random() * 100);
        row = temp / 10;
        column = temp % 10;
    } while (board[row][column] == 99);
    board[row][column] = 99;
}