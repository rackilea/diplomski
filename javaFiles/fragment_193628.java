public void checkGuess() {
    boolean disW = displayWord();

    if (!disW && incGuessCount == 5)
        fiveWrong();
    else if (!disW && incGuessCount < 5) {
        incGuessCount++;

    }

    if (corLetters == word.length()){
        gameOver = true;
    }
}