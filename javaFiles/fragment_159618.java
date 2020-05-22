public boolean saveIfHighest(int bid) {
    int currentBid = highestBid.get();
    while (currentBid < bid) {
        if (highestBid.compareAndSet(currentBid, bid)) {
            return true;
        }
        currentBid = highestBid.get();
    }
    return false;
}