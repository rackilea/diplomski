if (!(col < board[row].length - 1)) {
                        col = queensPos.pop();

                        row -= 1;
                        board[row][col] = false;
                        numQueens += 1;
                        col += 1;
                    } else {
                        col += 1;
                    }