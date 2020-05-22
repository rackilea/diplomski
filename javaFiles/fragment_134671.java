Scanner in = new Scanner(System.in);
boolean playAgain = true;
while(playAgain){
    matrix = clearBoard(matrix);
    do {
        //changes whose turn it is
        done = takeTurn(whoseTurn, matrix);
        if (whoseTurn == 'X')
            whoseTurn = 'O';
        else
            whoseTurn = 'X';
        } while (!done);
    String userInput = in.next();
    if(userInput.equals("Yes"))
        playAgain = true;
    else
        playAgain = false;
}