while(dealer.getHand().getTotal() <= 15 && 
        dealer.getHand().getTotal() <= getMaximumHandTotal()) {
   ...
}

private int getMaximumHandTotal() {
   int max = -1;
   for(Hand hand : player.getHands()) {
      if(hand.getTotal() > max) { max = hand.getTotal(); }
   }
   return max;
}