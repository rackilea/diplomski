//listener code implementation
//user has decided to raise...

int raiseAmount = ... // perhaps passed in thru listener or from UI objects
State currentState;  //current state before raise

currentState = currentState.player1Raises(raiseAmount);
//now state is for player 2 to decide what to do

//update UI to let player 2 decide what to do given current State