while (!isBoardSolved) {
    (x,y) = getUserInput(); // this is not java :D don't use it
    if (isLegalMove(x,y)) {
         makeMove(x,y);
    } else {
         reportError();
    }
    printBoard();
}