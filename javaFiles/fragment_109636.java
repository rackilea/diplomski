Collections.sort(sortedHand, new Comparator<Card>() {

@Override

public int compare(Card card1, Card card2) {
int rank1 = card1.getRank();
int rank2 = card2.getRank();

if (rank1 > rank2) {
    return 1;
}

if (rank1 < rank2){
    return -1;
}



return 0;
}

  }   /* Should be  );  here */ 


int rank = 0;
...