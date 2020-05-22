public class Board {

    private char [][] theBoard;

    public Board() { // This will not take any arguments
        this(10, 25); // calls the other constructor
        // avoid duplicate code, where possible
    }

    // takes number of rows and collumns
    public Board (int rows, int cols) {
        // fix illegal row and column numbers
        rows = fixNumber(rows);
        cols = fixNumber(cols);
        // create the board and fill it with ' '
        theBoard = new char [rows][cols];
        for (int row = 0; row < theBoard.length; row++) {
            for (int col = 0; col < theBoard[row].length; col++)
                theBoard[row][col] = ' ';
        }
    }

    private int fixNumber(int number) {
        if (number < 1) {
            return 1;
        } else if (number > 80) {
            return 80;
        } else {
            return number;
        }
    }

    // almost like constructor, just does not create a new char[][] and
    // only puts ' ' into fields not containing any of '0' - '9'
    public void clearBoard() {
        for (int row = 0; row < theBoard.length; row++ ) {
            for (int col = 0; col < theBoard[row].length; col++) {
                if (theBoard[row][col] < '0' || theBoard[row][col] > '9') {
                    theBoard[row][col] = ' ';   
                }
            }
        }
    }
}