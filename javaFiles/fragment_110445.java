public static void main(String[] args) {
    ArrayList<CreateCard> deckArray = new ArrayList<CreateCard>();
    deckArray.add(new CreateCard());
    deckArray.add(new CreateCard());

    ArrayList<CreateCard> playerHand = new ArrayList<CreateCard>();

    // Deal a card
    moveASpecificValue(deckArray, playerHand, 0);

    // Deal from the bottom of the deck
    moveASpecificValue(deckArray, playerHand, deckArray.size() - 1);
}

public static void moveASpecificValue( List<CreateCard> source, 
                                       List<CreateCard> destination, 
                                       int indexOfSpecificValue) {
    destination.add(source.remove(indexOfSpecificValue));
}