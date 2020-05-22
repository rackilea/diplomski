for(int r=0; r<secretPhrase.length(); r++){
    if(secretPhrase.charAt(r) == userChoice){
        secretWord.setCharAt(r, userChoice);
        guessedLetters++;
    }
}