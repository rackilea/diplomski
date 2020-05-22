private static Deck createDeck()
    {
        System.out.println("Creating deck...");
        Deck deck = new Deck(DECKSIZE);
        deck.createDeck();

        System.out.println("Shuffling deck...");
        deck.shuffleDeck();

        return deck;
    }