Deck<PokerCard> pokerDeck = new Deck<PokerCard>();

PokerCard c = pokerDeck.getTopCard();   
// now you know it is a PokerCard, not just any old card

pokerDeck.insert(new MagicTheGatheringCard()); 
// get a compile error for wrong card type