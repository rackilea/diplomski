public static boolean determineWin(String[][] board) {

    int[][][] counters = new int[board[0].length+1][board.length+1][4];

    for (int y=0; y<board.length; y++) {
        for (int x=0; x<board[0].length; x++) {
            if (!board[y][x].equals(".")) {
                counters[y][x][0] = (x>0 && board[y][x].equals(board[y][x-1])) ? counters[y][x-1][0] + 1 : 1;
                counters[y][x][1] = (y>0 && board[y][x].equals(board[y-1][x])) ? counters[y-1][x][1] + 1 : 1;
                // Diagonal 1 TODO:  counters[y][x][2] = 
                // Diagonal 2 TODO:  counters[y][x][3] = 
                if (counters[y][x][0] == 4 || counters[y][x][1] == 4 || counters[y][x][2] == 4 || counters[y][x][3] == 4)
                    return true;
            }
        }
    }
    return false;
}