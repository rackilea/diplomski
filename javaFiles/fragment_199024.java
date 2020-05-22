private boolean isInBounds(int i, int j) {
    return (board.length > 0 && i >= 0 && i < board.length && j >= 0 && j < board[i].length);
}

private boolean isAboveEmpty(int i, int j) { // This might be a little verbose...
    int newJ = j - 1;
    if(isInBounds(i, newJ)) 
        return board[i][newJ].equals(" "); //Above cell is empty
    return true; // out of bounds cells are always empty (or are they?)
}