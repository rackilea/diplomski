public List<Square> getValidMoves(Piece piece) {
    return piece.getPossibleMoves().
                 stream(). // and filter by 
                 filter(move -> isOnValidBoardCoordinate(move)). // can shorten
                 filter(move -> doesNotIntersectOtherPiece(move)).
                 filter(move -> otherValidation(move)).
                 collect(Collectors.toList());
}