for(int i=0;i<wordToGuess.length();i++)
{
    if(theGuess.equals(wordToGuess.substring(i,i+1)))
    {
        correctLetters[i]=theGuess;
        matches=true;
        numCorrect++;
    }
}