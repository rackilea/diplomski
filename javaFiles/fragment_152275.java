private final Random random = new Random();
private final Card[] cards = new Card[52];
// Populate the array in the constructor, or wherever

...

// When you want to draw the card...
g.drawImage(cards[random.next(52)], 10, this);