for (Suit suit : Suit.values()) {
    for (int y = 2; y < 15; y++) {
        cards[i] = new Card(y, suit.name());
        i++;
    }
}