private Card CardOne; //instance variable

public void revealCard(Card myCard) {
  myCard.flipCard(); //Whatever task you need to flip the card
  if (CardOne = null) {
     myCard = CardOne;
     return;
  }
  if myCard.isMatch(CardOne)) {
      //Do whatever you need to do when there is a match
  }
  else {
  this.flipCardsBackOver(myCard, CardOne) //Flip all up cards over and set Card1
        //to null
  }
}