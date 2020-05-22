public char GetGuess(){
    System.out.println("Please enter a letter to be guessed");
    Scanner guess = new Scanner(System.in);
    return guess.nextLine().charAt(0);
}

public boolean ValidateGuess(){
    boolean isHit = false;
    int triesLeft = MAX_TRIES;
    char guessValue = GetGuess(); //Here you store the guess and now you can work with that in your if conditions
    if (mCorrectAnswer.indexOf(guessValue) < 0 ){
        System.out.println("Your guess was incorrect");
        triesLeft -= 1;
        System.out.println(triesLeft);
        mMisses += guessValue;
    } else if (guessValue == (int)guessValue) {
        System.out.println("you have to input a letter!!!");
    } else {
        mHits += guessValue;
        isHit = true;
    }