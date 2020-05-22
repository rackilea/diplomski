int userWin = 0, compWin = 0;
int MAX_ATTEMPTS = 10;

while(MAX_ATTEMPTS > 0) {

    int userScore = 0, compScore = 0;
    //Roll the dice for user
    die1.roll();
    die2.roll();
    userScore = die1.getValue() + die2.getValue();

    //Roll the dice for comp
    die1.roll();
    die2.roll();
    compScore = die1.getValue() + die2.getValue();       

    // determine winner
    if (userScore > compScore) {
        System.out.println("User wins! \nUser score = " + userScore + ", Comp score = " + compScore);            
        userWin++;
    }
    else if (userScore < compScore) {
        System.out.println("Comp wins! \nUser score = " + userScore + ", Comp score = " + compScore);
        compWin++;
    } else {
        System.out.println("Draw!\nUser score = " + userScore + ", Comp score = " + compScore);
    }

    MAX_ATTEMPTS --;

}
System.out.println("User won = " + userWin + " times! ");  
System.out.println("Comp won = " + compWin + " times! ");