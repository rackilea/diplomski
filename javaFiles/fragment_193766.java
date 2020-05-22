public void dealCards( Players player1, Players player2, Players player3, Players player4 )
 {
  int count = 0;
  for ( final Card card : this.deckOfCards )
  {
     if ( count >= 39 )
     {
        player1.playCards[count % 13] = card;
     }
     else if ( count >= 26 )
     {
        player2.playCards[count % 13] = card;
     }
     else if ( count >= 13 )
     {
        player3.playCards[count % 13] = card;
     }
     else
     {
        player4.playCards[count % 13] = card;
     }
     count++;
  }
 }