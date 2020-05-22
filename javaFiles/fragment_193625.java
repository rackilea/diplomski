public void checkGuess()
{
    if(!checkWord() && incGuessCount==5)
        fiveWrong();
    else if(!checkWord() && incGuessCount<5)
    {
        incGuessCount++;
    }
}