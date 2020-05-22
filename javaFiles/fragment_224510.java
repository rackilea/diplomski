@Override
public Hand deal(Deck deck) throws OutOfCardsException {
    List<Card> tempCards = deck.getCards();

    int n = 5;
    Card[] dealCard = new Card[n];
    if(tempCards.size() >= 5) {
        for(int i = n - 1; i >= 0; i--) {
            dealCard[i] = tempCards.get(i);
            tempCards.remove(tempCards.size() - 1);
        }

        Set<Card> cards = new HashSet<Card>(Arrays.asList(dealCard));

        return new Hand(cards);
    }

    return null;
}