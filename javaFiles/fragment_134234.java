public boolean checkifEmpty(int fromRow, int fromColumn, int toRow,
        int toColumn, Figure[][] ChessBoard) {
    int differenceInRows = Math.abs(fromRow - toRow);

    for (int j = 1; j < differenceInRows; j++) {
        if ((toRow < fromRow) && (toColumn > fromColumn)
                && ChessBoard[fromRow - j][fromColumn + j] != null) {
            return false;
        } else if ((toRow > fromRow) && (toColumn > fromColumn)
                && ChessBoard[fromRow + j][fromColumn + j] != null) {
            return false;
        } else if ((toRow > fromRow) && (toColumn < fromColumn)
                && ChessBoard[fromRow + j][fromColumn - j] != null) {
            return false;
        } else if ((toRow < fromRow) && (toColumn < fromColumn)
                && ChessBoard[fromRow - j][fromColumn - j] != null) {
            return false;
        }

    }
    return true;
}