public class Blackjack {
    private Card[] deck;

    public Blackjack() {
        deck = new Card[52]; // Makes an array which holds 52 Card objects
        deck[0] = new Card(2, "Hearts");
        deck[1] = new Card(3, "Hearts");
        deck[2] = new Card(4, "Hearts");
        deck[3] = new Card(5, "Hearts");
        // And so on
    }
}