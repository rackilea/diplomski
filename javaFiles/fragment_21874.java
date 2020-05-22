int[][] physicalBoard0 = new int[21][21];
int[][] physicalBoard1 = new int[21][21];
boolean boardIs0 = true;
int[][] board = physicalBoard0;
int[][] newboard = physicalBoard1;

private void swapBoards() {
    boardIs0 = !boardIs0;
    if (boardIs0) {
        board = physicalBoard0;
        newBoard = physicalBoard1;
    } else {
        board = physicalBoard1;
        newBoard = physicalBoard0;
    }
}