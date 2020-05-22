public String[] getStats() {
    for(int i = 0; i < this.dealerhand.size(); i++) {
        dealerstats[i] = (dealerhand.get(i).showstats());
    }
    return dealerstats;
}