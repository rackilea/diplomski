public State(int parentStateID, int stateID, int[][] board, int[] pieces, int points, int acquiredPoints){
    State.parentStateID = parentStateID;
    State.stateID = stateID;
    State.currentBoard = cloneMatrix(board); //here takes place the matrix cloning
    State.currentPieces = cloneArray(pieces); //here takes place the array cloning
    State.totalPoints = points;
    State.acquiredPoints = acquiredPoints;
}