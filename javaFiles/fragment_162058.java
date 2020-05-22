public void addRank(ArrayList<Square> availableMoves, int startIndex, int endIndex) {
    int currX = this.square.getXCoord();
    int currY = this.square.getYCoord();

    addMoves(availableMoves,
            IntStream.iterate(currX + 1, i -> i < endIndex, i -> i + 1)
                    .mapToObj(i -> Game.board[i][currY]));

    addMoves(availableMoves,
            IntStream.iterate(currX - 1, i -> i >= startIndex, i -> i - 1)
                    .mapToObj(i -> Game.board[i][currY]));
}

public void addFile(ArrayList<Square> availableMoves, int startIndex, int endIndex) {
    int currX = this.square.getXCoord();
    int currY = this.square.getYCoord();

    addMoves(availableMoves,
            IntStream.iterate(currY + 1, i -> i < endIndex, i -> i + 1)
                    .mapToObj(i -> Game.board[currX][i]));

    addMoves(availableMoves,
            IntStream.iterate(currY - 1, i -> i >= startIndex, i -> i - 1)
                    .mapToObj(i -> Game.board[currX][i]));
}

private void addMoves(List<Square> availableMoves, Stream<Square> squares) {
    for(Iterator<Square> iter = squares.iterator(); iter.hasNext(); ) {
        Square square = iter.next();
        if(square.getHasPiece()) {
            if(hasOppositePiece(this, square)){
                availableMoves.add(square);
            }
            break;
        }
        availableMoves.add(square);
    }
}