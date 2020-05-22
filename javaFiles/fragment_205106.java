public final class Bidders {

    // I don't need a concurrent map any longer, I'm in control of the concurrency within
    // this class.
    private final Map<String, BidValue> bidders = new HashMap<String, BidValue>();

    public void updateBidder(String bidderName, BidValue value) {
        if (value != null) {
            synchronized (this) {
                // ensures we do not add while we're enumerating
                bidders.put(bidderName, value);
            }
        }
    }

    public List<PlayerBid> getBids() {
        List<PlayerBid> bids = new ArrayList<PlayerBid>();
        synchronized (this) {
            // ensures we do not add while we're enumerating,
            // if we returned the map
            // we couldn't guarantee this would happen.
            for (Entry<String, BidValue> entry : bidders.entrySet()) {
                bids.add(new PlayerBid(entry.getKey(), entry.getValue()));
            }
        }
        return bids;
    }

    // add other methods as you need, but avoid returning the internals of
    // this class
}