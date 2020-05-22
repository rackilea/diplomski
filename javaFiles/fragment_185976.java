public class Main {

    public static void main(String[] args) {

        String[] values = new String[]{"K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2", "A"};

        Card[] deck = new Card[52];

        int i = 0;
        for (Suit suit : Suit.values()) {
            for (String value : values) {
                deck[i++] = new Card(suit, value);
            }
        }

        for (Card card : deck) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

    }

}