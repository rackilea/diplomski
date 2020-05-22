int index = 0;
System.out.println( getPlayerName() + " discards a " + hand[index].getCardValue() + " to deck " + playerNumber );
CardGame.playingDeckArray[playerNumber-1].add( new Card( getHandValue(hand[index])));

for( int i = 1; i < hand.length+1; i++){
    if ( index == hand.length-1 ){
        hand[index] = null;
    }else{
        hand[index] = hand[index+i];
        index = index + i; 
    }
}