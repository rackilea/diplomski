import java.util.ArrayList;
import java.util.List;

public class CardTester {

    public static void main(String[] args) {

        List<Card> cardList = new ArrayList<>();
        Card lastCard = new Card(Card.Suit.SPADES, Card.Rank.ACE);

        for (Card.Suit suit : Card.Suit.values()) { 
            for (Card.Rank rank : Card.Rank.values()) {

                Card card = new Card(suit, rank);
                cardList.add(card);

                if (!card.equals(lastCard)) {
                    System.out.print(card + ", ");
                }
                else {
                    System.out.print(card);
                }
            }
        }

        // use cardList
    }
}