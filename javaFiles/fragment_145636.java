Function<Card, Rank> toRank = Card::getRank;
Comparator<Card> comp1 = (a, b) -> toRank.apply(a).compareTo(toRank.apply(b));
Function<Card, Suit> toSuit = Card::getSuit;
Comparator<Card> comp2 = (a, b) -> toSuit.apply(a).compareTo(toSuit.apply(b));
Comparator<Card> result = (a, b) -> {
  int res = comp1.compare(a, b);
  return res != 0 ? res : comp2.compare(a, b);
};