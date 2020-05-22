public ArrayList<Integer> shuffleDeck(ArrayList<Integer> Deck) {
    int x = 52;
    for (int i = 1; i <= x; ++i) {
        Deck.add(i);
    }
    Collections.shuffle(Deck);
    return Deck;

}