public State(int parentStateID, int stateID, int[][] board, int[] pieces, int points, int acquiredPoints){
    this.parentStateID = parentStateID;
    this.stateID = stateID;
    this.currentBoard = cloneMatrix(board); //here takes place the matrix cloning
    this.currentPieces = cloneArray(pieces); //here takes place the array cloning
    this.totalPoints = points;
    this.acquiredPoints = acquiredPoints;
}