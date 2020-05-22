int requestMove() {
    // 1. show user prompt to make a move
    // ...

    // 2. construct latch to wait for move done on UI thread
    mBoard.moveRequestedFlag = true;
    NextMove nextMove = new NextMove();
    mBoard.nextMove = nextMove;

    // 3. await for move and get the result
    return nextMove.getMove();
}