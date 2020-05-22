protected boolean isOffBoard(int x, int y) {
    return x < 0 || y < 0 || y >= board.length || x >= board[y].length;
}

protected boolean isOccupied(int x, int y) {
    if (isOffBoard(x, y)) {
        return true;
    }

    return board[y][x] != null;
}

protected boolean isOccupiedByPlayer(int player, int x, int y) {
    if (isOffBoard(x, y)) {
        return true;
    }
    if (!isOccupied(x, y)) {
        return false;
    }

    return board[y][x] == player;
}