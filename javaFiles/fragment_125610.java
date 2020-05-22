public Deck() {
    int index = 0;
    cards = new Card[52];
    for(int suitType = 0; suitType <= 3; suitType++) {
        for(int cardValue = 1; cardValue <= 13; cardValue++) {
            cards[index] = new Card(cardValue, suitType);
            index++;
        }
    }
}