public void shuffle() {
    final Random random = new Random(); // creat a random object

    Card memory;
    int randomPosition;
    for (int i = 0; i < numCards; i++) {
        randomPosition = random.nextInt(numCards); // assign a number
                                                    // between 0 to
                                                    // 52 as randomPosition
                                                    // for
                                                    // shuffle
        memory = deck[i]; // store the current deck[i] card
        deck[i] = deck[randomPosition]; // assign new card to current card
        deck[randomPosition] = memory; // assign current card to new card
    }

}