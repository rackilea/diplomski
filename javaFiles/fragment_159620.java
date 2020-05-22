public synchronized boolean saveIfHighest(int bid) {
    if (highestBid < bid) {
        highestBid = bid;
        return true;
    } else {
        return false;
    }
}