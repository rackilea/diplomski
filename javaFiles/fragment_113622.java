//Example:
int numOfRounds = 3;  //can receive this from user input
for(int x=0; x<numOfRounds; x++){
    rollDice(playerOne);
    rollDice(playerTwo);
    decideWinner(playerOne, playerTwo);            
}
displayFinalScore();