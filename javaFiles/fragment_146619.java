cards = new Card[DECK_SIZE];
String suits[] = {"spades", "hearts", "clovers", "diamonds"};
String cards[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Joker", "Queen", "King"};

int cardIndex = 0;
for (String suit : suits) {
    for (String card : cards) {
        cards[cardIndex] = new Card(suit, card);
        cardIndex++;
    }
}