public class MarketDataListLevel2 {

    public class BidAsk {
        protected double bid;
        protected double ask;
        private BidAsk(double bid, double ask) {
            this.bid = bid;
            this.ask = ask;
        }
        public String toString() { return "[" + bid + " x " + ask + "]"; }
    }

    protected BidAsk[] bidAskList;
    public MarketDataListLevel2(BidAsk[] bidAskList) {
        this.bidAskList = bidAskList;
    }       

    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (BidAsk bidAsk : bidAskList) {
            ans.append(bidAsk.toString());
        }
        return ans.toString();
    }
}