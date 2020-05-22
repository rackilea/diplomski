while(guessedLetters < asteriskAmount) {
        System.out.println("Please guess a letter");
        userChoice = Character.toUpperCase(input.nextLine().charAt(0));
    boolean isInPhrase = checkLetter(userChoice, secretPhrase);
    if(isInPhrase) { // if the guessed letter is a letter in the phrase...
        int position = getPosition(userChoice, secretPhrase); 
        secretWord.setCharAt(position, userChoice);
        hint = secretWord.toString();
        guessedLetters++; 
        System.out.println(secretWord);
    }
    else {
        System.out.println("That letter is not in the phrase. Please try again >>> ");
        userChoice = Character.toUpperCase(input.nextLine().charAt(0));
    }
}