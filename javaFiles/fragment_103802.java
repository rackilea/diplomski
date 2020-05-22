class Hand implements Comparable<Hand> {
    private final List<Card> cards;
    Hand(Card c1, Card c2, Card c3) {
        cards = Collections.unmodifiableList(Arrays.asList(c1, c2, c3));
    }
    //getters, no setters
    //implement compareTo
}