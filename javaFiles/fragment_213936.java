if (userGuess < randomNumber) {
    guess = tooWhat.tooLow;
}else if (userGuess > randomNumber) {
    guess = tooWhat.tooHigh;
}else { // *** No `if`
    guess = tooWhat.justRight;
}