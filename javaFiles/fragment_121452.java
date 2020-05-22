public void rollTheDiceAndMove() 
{
    int diceRoll = gameBoard.rollDice();
    System.out.println("Player: rolling the dice");

    PauseTransition pause = new PauseTransition(Duration.seconds(1));
    pause.setOnFinished(event ->{
        System.out.println("1 second after rolling the dice");
        gameGUI.indicateDiceRoll(diceRoll);
        int newIndex = getPlayerIndexAfterRoll(diceRoll);
        playerMove(newIndex);
        if(checkWin(Player))
        {
            System.out.println("Player won!");                
        }
        else
        {
            System.out.println("change turns");
            swapTurns();
            System.out.println(isComputerTurn());
            gameGUI.updateCurrentTurnLabel();
            computerRollDiceAndMove();
        }






    });
    pause.play();
}