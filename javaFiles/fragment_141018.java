//Computers turn to roll the dice.
    public void computerTurn() {

        computerTurnNumber = 0; // here

        turnScore = 0;
        System.out.println("Computer's turn: ");
        while (computerTurnNumber < 20) { // here is the amount of time the dice will be rolled
            rollTheDice();
            computerTurnNumber++;
            setComputerTotalScore(turnScore);
        }
        getGameScore();
        enterToContinue();
    }