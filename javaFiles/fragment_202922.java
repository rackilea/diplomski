private static final int SUIT_SPADES = 1;
private static final int SUIT_CLUBS = 2;
private static final int SUIT_HEARTS = 4;
private static final int SUIT_DIAMONDS = 8;

private static final int[] SUITS = new int[] { 
   SUIT_SPADES, SUIT_CLUBS, SUIT_HEARTS, SUIT_DIAMONDS };

...
for ( int suit : SUITS ) { ... }