final int maxx = 7;
final int maxy = 6;

char winner(char[][] board) {
    int[][] directions = {{1,0}, {1,-1}, {1,1}, {0,1}};
    for (int[] d : directions) {
        int dx = d[0];
        int dy = d[1];
        for (int x = 0; x < maxx; x++) {
            for (int y = 0; y < maxy; y++) {
                int lastx = x + 3*dx;
                int lasty = y + 3*dy;
                if (0 <= lastx && lastx < maxx && 0 <= lasty && lasty < maxy) {
                    char w = board[x][y];
                    if (w != ' ' && w == board[x+dx][y+dy] 
                                 && w == board[x+2*dx][y+2*dy] 
                                 && w == board[lastx][lasty]) {
                        return w;
                    }
                }
            }
        }
    }
    return ' '; // no winner
}