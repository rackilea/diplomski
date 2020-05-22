gameOver = checkWinRows(board, rowMax, colMax);
if(!gameOver) {
    gameOver = checkWinVertical(board, rowMax, colMax);
}
if(!gameOver) {
    gameOver = checkWinFSlash(board, rowMax, colMax);
}
...