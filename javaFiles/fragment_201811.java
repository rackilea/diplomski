Iterator<Card> cardIterator = deck.iterator();
while (cardIterator.hasNext())
{
  Card aCard = cardIterator.next();
  System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
}