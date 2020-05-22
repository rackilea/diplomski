boolean isFourInARow(int x, int y) {
    return 
       lengthOfLineContaining(int x, int y, 0, 1) >= 4 ||
       lengthOfLineContaining(int x, int y, 1, 1) >= 4 ||
       lengthOfLineContaining(int x, int y, 1, 0) >= 4 ||
       lengthOfLineContaining(int x, int y, 1, -1) >= 4;
}