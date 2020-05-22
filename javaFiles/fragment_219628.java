int index = 0;
public void addCard(int card) {
  if (index == MAX_HAND) {
            return;
  }
  playerHand[index++] = card;
}