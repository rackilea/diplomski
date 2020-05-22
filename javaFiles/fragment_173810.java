public Auction(Auction auction) {

   this();

   if (!auction.openClosed) {
      lots.addAll(auction.getNoBids());
      // set close flags as necessary...
   }
}