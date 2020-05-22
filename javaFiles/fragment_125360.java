public class Card  {

    private Suit suit = null;
    private String cardRank;
    private int cardValue = 0;

    public Card(Suit suit, String cardRank, int cardValue) {
        this.cardRank = cardRank;
        this.suit = suit;
        this.cardValue = cardValue;
    }

}