Object[][] board = new Object[7][700];  //Game board.  
//you can also switch the width and height
//Initialization

for (int x = 699; x >= 0; x--) {
    for (int y = 0; y < 7; y++) {
        if (x == 699) {
            board[y][x] = BLANK; //set spot to open if it is the bottom row
            continue;
        }
        board[y][x+1] = board[y][x]; //move row down
    }
}
//Generate new Objects if needed for the top row of the board.