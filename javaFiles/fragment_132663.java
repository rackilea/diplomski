System.out.println("Original Deck Of Cards");
for (int i = 0; i < RANKS.length; i++) {
    for (int j = 0; j < SUITS.length; j++) {
        deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
        System.out.println(deck[SUITS.length * i + j]);
    }
}