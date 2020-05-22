import java.util.ArrayList;

public class Deck {

    private ArrayList cards;

    public enum Suit {Joker, Spade, Club, Heart, Diamond};

    public Deck() {
        cards = new ArrayList<Card>();

        // Add all appropriate cards
        for(int i = 1; i < 14; i++) {
            cards.add(new Card(i, Suit.Spade));
            cards.add(new Card(i, Suit.Club));
            cards.add(new Card(i, Suit.Heart));
            cards.add(new Card(i, Suit.Diamond));
        }

        cards.add(new Card(0, Suit.Joker));
        cards.add(new Card(0, Suit.Joker));

    }

    public Card dealRandomCard() {
        int random = (int)(Math.random()*cards.size());
        Card c = cards.get(random)
        cards.remove(random);
        return c;
    }

}