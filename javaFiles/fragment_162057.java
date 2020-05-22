public void addRank(ArrayList<Square> availableMoves, int startIndex, int endIndex) {
    int currX = this.square.getXCoord();
    int currY = this.square.getYCoord();

    for(int i = currX + 1;
            i < endIndex && addMove(availableMoves, Game.board[i][currY]);
            i++);

    for(int i = currX - 1;
            i >= startIndex && addMove(availableMoves, Game.board[i][currY]);
            i--);
}

public void addFile(ArrayList<Square> availableMoves, int startIndex, int endIndex) {
    int currX = this.square.getXCoord();
    int currY = this.square.getYCoord();

    for(int i = currY + 1;
            i < endIndex && addMove(availableMoves, Game.board[currX][i]);
            i++);

    for(int i = currY - 1;
            i >= startIndex && addMove(availableMoves, Game.board[currX][i]);
            i--);
}

private boolean addMove(List<Square> availableMoves, Square square) {
    if(square.getHasPiece()) {
        if(hasOppositePiece(this, square)) {
            availableMoves.add(square);
        }
        return false;
    }
    availableMoves.add(square);
    return true;
}