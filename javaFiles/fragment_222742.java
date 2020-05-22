while(guessedLetters < asteriskAmount) {
        System.out.println("Please guess a letter");
        userChoice = Character.toUpperCase(input.nextLine().charAt(0));
    boolean isInPhrase = checkLetter(userChoice, secretPhrase);
    if(isInPhrase) { // if the guessed letter is a letter in the phrase...
        for(int r=0; r<secretPhrase.length(); r++){
            if(secretPhrase.charAt(r) == userChoice){
                secretWord.setCharAt(r, userChoice);
                guessedLetters++;
            }
        }
        System.out.println(secretWord);
    }
    else {
        System.out.println("That letter is not in the phrase. Please try again >>> ");
        userChoice = Character.toUpperCase(input.nextLine().charAt(0));
    }
}