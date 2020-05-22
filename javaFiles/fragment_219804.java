public Card(String suit, String rank) {
    if (NoC >= 52) {
        throw new IllegalStateException("You cannot create any more cards");
    }

    this.suit = suit;
    this.rank = rank;

    cards = new String[54][2];
    cards[NoC][0] = this.suit;
    cards[NoC][1] = this.rank;
    NoC = NoC + 1;
}