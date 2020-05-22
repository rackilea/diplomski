int lengthOfLineStartingAt(int x, int y, int xStep, int yStep) {
     char colour = grid[x][y];
     int i = 0;
     while(grid[x][y] == colour) { 
        x = x + xStep;
        y = y + yStep;
        i++;
     }
     return i;
}