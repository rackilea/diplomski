public class Deck {
    private final Queue<Card> queue = new LinkedList<>();

    private ICardShuffler cardShuffler;

    public Deck(ICardShuffler cardShuffler) {
        this.cardShuffler = cardShuffler;
    }
    ...
    public void shuffle() {
        cardShuffler.shuffle((List<Card>)queue);
    }
    ...