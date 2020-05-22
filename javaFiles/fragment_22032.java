ChessPiece[][] originalBoard = new ChessPiece[InGameActivity.currentBoardState.length][];
for(int i = 0; i < InGameActivity.currentBoardState.length; i++){
    ChessPiece[] pieces = InGameActivity.currentBoardState[i];
    int len = pieces.length;
    originalBoard[i] = new ChessPiece[len];
    System.arraycopy(pieces, 0, originalBoard[i], 0, len);
}

//Rest of code here...