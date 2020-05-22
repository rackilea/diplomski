public boolean checkWord()            
{
    boolean goodGuess = false;//Assumes guess is bad automatically
    char letter = guessedLetter.charAt(0);
    for(int i = 0;i<word.length();i++){//Goes through all the letters to check guess's status
        if (word.charAt(i)==letter)
        {
            lettersFound[i] = true;
            goodGuess = true;
        }
    }

    return goodGuess;           
}