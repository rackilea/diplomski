class Letter {
 char c;
boolean isRevealed;

//... getters and setters
}

Letter[] word = new Letter[MAX_WORD_LENGTH]; 

private boolean isGuessRight(char chr){
        for (int i = 0 ; i < word.length ; i++){
            if (word[i].getChar() == chr && word[i].getRevealed() == false){
                word[i].reveal();
                return true;
            }
            else if (word[i] == chr && word[i].getRevealed()){
                return false;
            }
        }
    }