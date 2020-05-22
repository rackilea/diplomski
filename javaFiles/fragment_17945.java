public char [] canWin(){
    char winner = 'N';
    int catCheck = 1;
    char [] result=new char[2];
    for(int i=1; i<10; i++){
        winner = 'N';
        //Places an X if a cell is not occupied
        if(!elementMarked(ComputerPlayer.Convert(i)[0], ComputerPlayer.Convert(i)[1]))
            markFirst(ComputerPlayer.Convert(i)[0],ComputerPlayer.Convert(i)[1]);
        else //If cell is occupied, skip this iteration
            continue;

        // Check the columns
        for (int column = 0; column < 3; column++) {
            int accumulation = myBoard[0][column] * myBoard[1][column] * myBoard[2][column];

            if (accumulation == 8) // 2*2*2 = 8, a win for X
            {
                winner = 'X';
                break;
            }
            if (accumulation == 1) // 1*1*1 = 1, a win for O
            {
                winner = 'O';
                break;
            }
        }

        if (winner != 'N'){
            result[0] = winner; //register winner
            result[1]=(char)i;  //register cell that led to win
            myBoard[ComputerPlayer.Convert(i)[0]][ComputerPlayer.Convert(i)[1]] = 0; //undoing the cell selection
            return result;
        }

        // Check the rows
        for (int row = 0; row < 3; row++) {
            int accumulation = myBoard[row][0] * myBoard[row][1] * myBoard[row][2];
            if (accumulation == 8) {
                winner = 'X';
                break;
            }
            if (accumulation == 1) {
                winner = 'O';
                break;
            }
        }

        if (winner != 'N'){
            result[0] = winner; //register winner
            result[1]=(char)i;  //register cell that led to win
            myBoard[ComputerPlayer.Convert(i)[0]][ComputerPlayer.Convert(i)[1]] = 0; //undoing the cell selection
            return result;
        }

        // Check one diagonal
        int accumulation = myBoard[0][0] * myBoard[1][1] * myBoard[2][2];
        if (accumulation == 1)
            winner = 'O';
        if (accumulation == 8){
            winner = 'X';
            result[0] = winner; //register winner
            result[1]=(char)i;  //register cell that led to win
            myBoard[ComputerPlayer.Convert(i)[0]][ComputerPlayer.Convert(i)[1]] = 0; //undoing the cell selection
            return result;
        }

        // Check the other diagonal
        accumulation = myBoard[0][2] * myBoard[1][1] * myBoard[2][0];
        if (accumulation == 1)
            winner = 'O';
        if (accumulation == 8){
            winner = 'X';
            result[0] = winner; //register winner
            result[1]=(char)i;  //register cell that led to win
            myBoard[ComputerPlayer.Convert(i)[0]][ComputerPlayer.Convert(i)[1]] = 0; //undoing the cell selection
            return result;
        }

        // If nobody's won, Check for a cat's game
        if (winner == 'N') {
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    catCheck *= myBoard[row][column];
                }
            }
            // any empty space is a zero. So product is zero if there is space
            // left.
            if (catCheck != 0)
                winner = 'C';
        }

        result[0] = winner; //register winner
        result[1]=(char)i;  //register cell that led to win
        myBoard[ComputerPlayer.Convert(i)[0]][ComputerPlayer.Convert(i)[1]] = 0; //undoing the cell selection
    }
    return result;
}