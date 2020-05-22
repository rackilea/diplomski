private static final String[] SUIT_NAMES = { "Hearts", "Clubs", "Diamonds",
    "Spades" };
// Fill in the rest yourself
private static final String[] VALUE_NAMES = { "Ace", "2", "3" ... "King" };

private final String suitName;
private final String valueName;

public Card(int suit, int value) {
    this.suitName = SUIT_NAMES[suit];
    this.valueName = VALUE_NAMES[value];
}