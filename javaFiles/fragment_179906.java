public static int stacker(boolean[][] board, int numQueens) {
        Stack<Integer> queensPos = new Stack<Integer>();
        int row = 0;
        int col = 0;
        int numSolutions = 0;
        int colLastUsed = 0;
        // need to figure out how to tell program to
        // go back to previous row and remove queen
        // if col = 3 and row = 1, queen will always be placed there
        // however if queen is placed there, there is no solution
        // if row being worked on is in the board
        while (row <= board.length) {
            // if you have no more queens to place
            if (numQueens == 0) {
                // you have a solution
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j]) {
                            System.out.print("Q");
                        } else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
                /*for (int i = 0; i < queensPos.size(); i++) {
                    System.out.print(queensPos.get(i) +" ");
                }
                System.out.println();*/
                numSolutions += 1;
                // go back to last row
                row -= 1;
                // remove queen
                col = queensPos.pop();
                board[row][col] = false;
                // go back one row
                //row -= 1;
                numQueens += 1;
                if (col < board.length - 1) {
                    // add one to col if it is not at end of row
                    col += 1;
                } else {
                    // go back another row
                    row -= 1;
                    col = queensPos.pop();

                    board[row][col] = false;

                    numQueens += 1;
                    col += 1;
                }
            // if there is a conflict and column is within board

            } else {
                if (col == board[row].length && row == 0) {
                    break;
                } else if (IsConflictPresent(board, row, col) && col < board[row].length - 1) {
                    // shift queen rightward
                    col += 1;
                    // if column is out of board
                } else if (IsConflictPresent(board, row, col) && col == board[row].length - 1) {
                    // look at value of column, if it is at end of board
                    // go back to previous row
                    // looks at top of stack
                    col = queensPos.pop();

                    if (row > 0) {
                        row -= 1;
                    }
                    board[row][col] = false;
                    numQueens += 1;
                    // attempt to solve problem where queen at end of 2nd row would keep getting placed
                    // appears to be working
                    if (!(col < board[row].length - 1) && row > 0) {
                        col = queensPos.pop();

                        row -= 1;
                        board[row][col] = false;
                        numQueens += 1;
                        col += 1;
                    } else {
                        col += 1;
                    }
                    // how to check to see if the column number you used
                } else {
                    // if queen can be placed
                    // place queen at row, col
                    board[row][col] = true;
                    queensPos.push(col);
                    numQueens -= 1;
                    // move to next row
                    row += 1;
                    // start at beginning of row
                    col = 0;

                }
            }

        }
        return numSolutions;
    }