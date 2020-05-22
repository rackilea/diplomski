private void newGame() {
    // Check game state
    if(dictionary.size() < 1) {
        // Do gameover stuff here
        return;
    }

    //get random word from the dictionary
    currentWord = dictionary.get(r.nextInt(dictionary.size()));

    ...
}