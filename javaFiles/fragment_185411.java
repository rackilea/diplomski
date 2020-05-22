public Hand(Hand handIn) {
    this.handSize = handIn.handSize;
    this.cardsInHand = 0;
    this.hand = new Card[this.handSize];
    // Yes, I know there is a better way to do this, but
    // I want the OP to learn something
    for (int index = 0; index < handIn.hand.length; index++) {
        Card card = handIn.hand[index];
        if (card != null) {
            hand[cardsInHand] = card;
            cardsInHand++;
        }
    }
}//end Copy Constructor