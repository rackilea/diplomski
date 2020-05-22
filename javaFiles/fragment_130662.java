// super class for both Deck and Hand
abstract class CardCollection implements Iterable<Card> {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card discardCard() {
        // TODO: throw an exception if size is 0
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int size() {
        return cards.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public String toString() {
        return "CardCollection [cards=" + cards + "]";
    }

    public void clear() {
        cards.clear();
    }

}