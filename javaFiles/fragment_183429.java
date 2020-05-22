List<Card> deck = new ArrayList<>(208); //we're telling the list that we expect 208 elements

//build two cards for each combination and add them to the deck
for( int value = 1; value  <= 14; value++ ) {
  for( CardType type : CardType.values() ) {
    for( Color color : Color.values() ) {
      deck.add( new Card( value, type, color ) );
      deck.add( new Card( value, type, color ) );
    }
  }
}

//shuffle the deck
Collections.shuffle( deck );