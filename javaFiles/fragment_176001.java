// handling card onClick somewhere on UI thread
if (mBoard.moveRequestedFlag) { // our controller waits for the move
    // get the position and report
    int cardIndex = ... // get index of what user clicked
    mBoard.moveReqestedFlag = false; // we handled the move
    mBoard.nextMove.setMove(cardIndex); // this will unblock controller's thread
}