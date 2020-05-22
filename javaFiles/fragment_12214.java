public void givenLetter(){
    String givenLetter = player1.giveLetter(); // Get the letter
    while (guessedLetters.containsKey(givenLetter)) {  // While the given letter is found, continue to run the method.
        givenLetter = player1.giveLetter();
    }  // Exit the loop once the given letter is not found
    // Rest of function here
}