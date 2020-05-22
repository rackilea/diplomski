private void checkPhrase(char chosenLetter){
    //Handle the Hangman-like logic here
    boolean isVowel = vowels.indexOf(chosenLetter) >= 0;
    if (isVowel) {
        System.out.println("User provided a vowel");
    }
}