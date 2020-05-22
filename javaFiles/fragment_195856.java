public static void main(String[] args) {
    int i = (int)( Math.random() * 101);
    int NumberToGuess = i;
    System.out.println("rand is " + NumberToGuess);
    int NumberOfTries = 0;
    Scanner input = new Scanner(System.in);
    int GuessedNumber;
    boolean win = false;

    while (win == false)
    {
        System.out.print( "Take a Guess Between Number 1 ~ 100! ");
        GuessedNumber = input.nextInt();
        NumberOfTries++;

        if ( GuessedNumber < NumberToGuess )
        {
            System.out.print( "Your Guessed Number is Too Low!" );
        }
        else if ( GuessedNumber > NumberToGuess )
        {
            System.out.print( " Your Guessed Number is Too High!");
        }
        else 
        {
            win  = true;
        }

    }

    System.out.print( "Your Guessed Number is Correct! You Win!");
    System.out.print( "The Number To Guess Was:" + NumberToGuess );
    System.out.print( "The Total Number Of Tries You Took is:" + NumberOfTries );

}