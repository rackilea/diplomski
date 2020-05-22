List<String> suits = new ArrayList<String>();
suits.add("CLUBS");
suits.add("DIAMONDS");
suits.add("HEARTS");
suits.add("SPADES");

Card[] cards = new Card[52];
int i = 0;
for (String suit : suits) {
    for (int y = 2; y < 15; y++) {
        cards[i] = new Card(y, suit);
        i++;
    }
}