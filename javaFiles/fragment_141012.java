public class Deck {

public ArrayList<Card> cards = new ArrayList<>();
Card next;
int currentCardIndex = -1;

/* The initialization stuff you have above */

public Card getNextCard() {

    currentCardIndex++;

    // If we're at the end, go back to the beginning
    if (currentCardIndex >= cards.size()) {
        currentCardIndex = 0;
    }

    return (next = cards.get(currentCardIndex));
}