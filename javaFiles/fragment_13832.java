public String[] getStats(Dealer dealer) { // Input a dealer
    String[] dealerstats = new String[dealer.dealerhand.size()]; // Initialize String array
    for(int i = 0; i < this.dealerhand.size(); i++) {
        dealerstats[i] = dealerhand.get(i).showstats();
    }
    return dealerstats;
}