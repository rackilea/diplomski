private static Deck checkDeck(Deck deck)
    {
        if(deck == null)
            return createDeck();

        if(deck.isEmpty())
        {
            System.out.print("Deck is empty! You must recreate and reshuffle deck of cards!\n");
            return createDeck();
        }

        return deck;
    }