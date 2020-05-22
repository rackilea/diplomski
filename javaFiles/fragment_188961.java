public class Board {
    public char board[][] = new char[9][9];

    // this is the constructor, it will be called if you say "new Board()"
    // the "main" method you had here will not be called automatically
    public Board() {
        for (int i = 0; i < 9; i++) {
            board[i][0] = '_';
            board[i][8] = '_';
        }
        for (int h = 0; h < 9; h++) {
            board[0][h] = '|';
            board[8][h] = '|';
        }

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                // just a print so it does not make new lines for every char
                System.out.print(board[x][y]);
            }
            // new line once one column (board[x][0] - board[x][8]) is printed
            // note: you proably want to turn around the x and y above since
            // I guess you want to print rows instead of columns
            System.out.println();
        }
    }
}