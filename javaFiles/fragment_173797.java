public class Deck {
public static void main(String[] args) {
    Card[] deck = initDeck();

    int counter = 0;
    do {
        shuffle(deck);
        counter++;
    } while (!isFourOfAKind(deck));

    System.out.print(deck[0] + ", ");
    System.out.print(deck[1] + ", ");
    System.out.print(deck[2] + ", ");
    System.out.println(deck[3]);
    System.out.println();
    System.out.println("Number of iterations (counter): " + counter);

    // print shuffled deck
    System.out.println("All of the deck");
    for (int i = 0; i < deck.length; i++) {
        System.out.println(deck[i]);
    }
}

private static Card[] initDeck() {
    String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] RANKS = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

    int n = 52;
    Card[] deck = new Card[n];
    for (int i = 0; i < RANKS.length; i++) {
        for (int j = 0; j < SUITS.length; j++) {
            deck[SUITS.length * i + j] = new Card(SUITS[j], RANKS[i]);
        }
    }
    return deck;
}

private static boolean isFourOfAKind(Card[] deck) {
    return deck[0].rank.equals(deck[1].rank) && deck[1].rank.equals(deck[2].rank)
            && deck[2].rank.equals(deck[3].rank);
}

private static void shuffle(Card[] deck) {
    for (int i = 0; i < deck.length; i++) {
        int r = i + (int) (Math.random() * (deck.length - i));
        Card temp = deck[r];
        deck[r] = deck[i];
        deck[i] = temp;
    }
}

public static class Card {
    public final String suit;
    public final String rank;

    public Card(String suit, String rank) {
        super();
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

}