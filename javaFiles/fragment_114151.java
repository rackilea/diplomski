public class PokerPlayer {
...
public Card getCard(int index) {
  return this.cardsOnHand[index];
}

public void setCard(int index, Card card) {
  this.cardsOnHand[index] = card;
}
...
}