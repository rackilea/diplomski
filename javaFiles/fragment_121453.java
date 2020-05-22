public void computerRollDiceAndMove()
{
    int diceRoll = gameBoard.rollDice();
    System.out.println("Computer: rolling the dice");

    PauseTransition pause = new PauseTransition(Duration.seconds(1));
    pause.setOnFinished(event ->{
        System.out.println("1 second after rolling the dice");
        gameGUI.indicateDiceRoll(diceRoll);
        int newIndex = getComputerIndexAfterRoll(diceRoll);
        computerMove(newIndex);
        if(checkWin(computer))
        {
            System.out.println("Computer won!");
        }
        else{
            System.out.println(isComputerTurn());
            gameGUI.updateCurrentTurnLabel();
        }
    });
    pause.play();   
}