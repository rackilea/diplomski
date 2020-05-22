public boolean fillBoard(int[][] board, int row, int col){
    int index = 1;              //Next value to try when an empty is found
    boolean solved = false;

    for(int i = row; i < width; i++){       //For each row
        for(int j = col; j < height; j++){  //For each column
            if(board[i][j]==0){             //0 represents empty
                while(!solved){             //While the puzzle is unsolved
                    board[i][j] = index;    //Try to fill with index
                    if(checker.checkRow(board[i]) 
                            && checker.checkColumn(columnToArray(board, j))
                            //&& checker.checkBox(<input>)
                            ){
                            solved = fillBoard(board, i, 0); //Next space
                    }
                    if(!solved) board[i][j] = 0;
                    if(index < width){
                        index++;
                    }else{
                        return false;
                    }                        
                }
            }
        }
    }
    puzzle = copyPuzzle(board);
    return true;
}