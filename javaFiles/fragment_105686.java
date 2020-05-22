import java.util.ArrayList;
import java.util.List;

public class Hand {
private int points = 0;
private int numberOfCards = 0;
private List<Card> hand = new ArrayList<>();


public Hand(List<Card> cards) {
    hand.addAll(cards);
    numberOfCards += cards.size();
    for(Card card: cards){
        points += card.points;
    }
} //End hand constructor

public void addCard(Card card){
    hand.add(card);
    points += card.points;
    numberOfCards += 1;
}

public int getNumberOfCards() {
    return numberOfCards;
}

public int getPoints() {
    return points;
}


}