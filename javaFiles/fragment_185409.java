public Hand() {
    this(5);
}//end Default Constructor

public Hand(int handSize) {
    this.handSize = handSize;
    this.cardsInHand = cardsInHand;
    this.hand = new Card[handSize];
}//end Parameterized Constructor