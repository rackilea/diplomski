public int getMiniMaxMove(Board board){
    int score = -1;
    int bestMove = -1;

    for(int i : getPossibleMoves(board)){
        Board copyBoard = new Board(board.getCells());
        copyBoard.setCell(i, mySymbol);
        int moveScore = minimax(copyBoard,false,mySymbol);

        if(moveScore >= score){
            score = moveScore;
            bestMove = i;
        }
    }

    return bestMove;
}


private int minimax(Board board, boolean maximizingPlayer, char symbol){
    Board copyBoard = new Board(board.getCells());
    char winner = copyBoard.checkWin();
    if(winner!='-' || copyBoard.checkDraw()){
        return score(winner);
    }


    if(maximizingPlayer){
        int bestValue = Integer.MIN_VALUE;
        for(Board b : simulatePossibleMoves(copyBoard,mySymbol)){
            int value = minimax(b,false,switchSymbol(mySymbol));
            if(bestValue < value){
                bestValue = value;
            }
        }
        return bestValue;
    }
    else{
        int bestValue = Integer.MAX_VALUE;
        for(Board b: simulatePossibleMoves(copyBoard, switchSymbol(mySymbol))){
            int value = minimax(b,true,mySymbol);
            if(bestValue > value){
                bestValue = value;
            }
        }
        return bestValue;
    }
}