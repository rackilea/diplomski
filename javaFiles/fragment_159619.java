for(int currentBid = highestBid.get(); currentBid < bid; currentBid = highestBid.get()) {
    if (highestBid.compareAndSet(currentBid, bid)) {
        return true;
    }
}
return false;