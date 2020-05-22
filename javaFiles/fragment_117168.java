// y = row number, so y = y + 1 means the row below y
// x = column number. so x = x + 1 means the column to the right of x
public boolean isSolved(char[][] board) {
    // check horizontal rows
    return isHorizontalSolved(board) || isVerticalSolved(board) || isDiagonalSolved(board);
}

public boolean isHorizontalSolved(board) {
    for (int y = 0; y < board.length; ++y) { 
        // for each row, test if all columns are the same
        boolean solved = true;
        char first = board[y][0];
        for (int x = 0; x < boards[y].length; ++x) {
            if (boards[y][x] == ' ' || first != boards[y][x]) { 
                // if an element is not filled in, this row is not solved
                // if an element in this row is different than any other element, this row is not solved
                solved = false;          
            }
        }
        if (solved == true) {
            return true;
        }
    }
    return false;
}

// check vertical rows
// leaving this for your own imagination

// check diagonals
public boolean isDiagonalSolved(char[][] board) {
    // check topLeft to bottomRight:
    char first = board[0][0];
    boolean solved = true;
    for (int y = 0, x = 0; y < board.length && x < board[y].length; ++y, ++x) {
        if (board[y][x] == ' ' || first != board[y][x]) {
            // if field is empty or the fields are not all equal to one another
            solved = false;
        }
    }
    if (solved) {
        return true;
    }

    int topRightX = board[0].length - 1;
    solved = true;
    first = board[0][topRightX];
    for (int y = 0, x = topRightX; y < board.length && x >= 0; ++y, --x) {
        if (board[y][x] == ' ' || first != board[y][x]) {
            // if field is empty or the fields are not all equal to one another
            solved = false;
        }
    }
    if (solved) {
        return true;
    }

}