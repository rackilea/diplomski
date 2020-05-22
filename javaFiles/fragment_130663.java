class Deck extends CardCollection {
    public Deck() {
        renew();
    }

    public void renew() {
        clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                addCard(new Card(suit, rank));
            }
        }
        Collections.shuffle(getCards());
    }

    public Card deal() {
        return discardCard();
    }

}