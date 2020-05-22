public enum Bidders {

    INSTANCE;

    //Everything below here is exactly as previous example.

    private final ConcurrentMap<String, BidValue> bidders = new ConcurrentHashMap<String, BidValue>();

    public void updateBidder(String bidderName, BidValue value){
      //.. exactly as previous example
    }

    //.. exactly as previous example
}