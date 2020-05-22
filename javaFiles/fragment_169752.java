private void userInput(int row, int col, boolean revealMines){
    Cell f = board[row][col];
    if (resp == 'r') {

        // if this cell is a mine and we are not revealing mines, return:
        if (f.mine && !revealMines)
            return;

        if (f.hidden) {