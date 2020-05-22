private static Deck initialDraw(Deck deck, Hand player, Hand dealer)
{
    deck = checkDeck(deck);
    drawFromDeck(deck, player); // drawing players card
    deck = checkDeck(deck);
    drawFromDeck(deck, dealer); // drawing dealers card
    deck = checkDeck(deck);
    drawFromDeck(deck, player); // drawing players card
    deck = checkDeck(deck);
    drawFromDeck(deck, dealer); // drawing dealers card

    System.out.print("Dealers Hand:");
    dealer.displayHand();
    System.out.print(" = " + dealer.getHandTotal() + "\n");
    System.out.print("Players Hand:");
    player.displayHand();
    System.out.print(" = " + player.getHandTotal() + "\n");

    checkInitialDraw(player, dealer);
    return deck;
}