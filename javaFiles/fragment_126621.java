public static void main(String [] args)
{
    Deck deck = new Deck();
    int cards = 5;  // pull 5 cards
    for (int i=0 ; i < cards; i++ )
      deck.deal();
    System.out.println(deck.cardsDealtList());
}