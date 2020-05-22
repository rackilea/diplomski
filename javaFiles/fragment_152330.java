class Piece {
    private final PieceType pieceType;
    // position and all...

    Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    // behavior that delegates to the pieceType whenever necessary
}