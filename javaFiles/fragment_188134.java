public Suit getSuit(int cardIndex){
     int suitNo = cardIndex/13;

     return matchingSuit(suitNo);
}

public Rank getRank(int cardIndex){
     int rankNo = cardIndex % 13;

     return matchingRank(rankNo);
}