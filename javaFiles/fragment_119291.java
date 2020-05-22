int count = 0;
    int xWins = 0;
    int oWins = 0;
    int ties = 0;
    boolean doPrint = true;
    while (count < 1000){
        int gameResult = randomTicTacToeGame(doPrint);

        if (gameResult == 1){
            xWins += 1;
        }
        if (gameResult == -1){
            oWins += 1;
        }
        if (gameResult == 0){
            ties += 1;
        }

        if (count >= 10){
            doPrint = false;
        }
        count++;
    }
    System.out.println();
    System.out.println("X Wins: " + xWins + "\n" + "O Wins: " + oWins + "\n" + "Ties: " + ties);