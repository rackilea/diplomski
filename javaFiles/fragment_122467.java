public boolean inMaze(int row, int col) {
    if (row >= 0 && col >= 0 && row < getWidth() && col < getHeight() ) {
        return true; 
    }
    return false;
}