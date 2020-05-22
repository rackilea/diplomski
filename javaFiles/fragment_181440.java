class Auction {

    private String description;

    List<Bid> bids = new ArrayList<Bid>();

    public void addBid(Bid bid) {
        if (CollectionUtils.isEmpty(this.bids)) {
            bids = new ArrayList<Bid>();
        }
        bids.add(bid);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}

class Bid {
    private String userName;

    private double price;
}