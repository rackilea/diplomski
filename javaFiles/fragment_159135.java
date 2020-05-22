public int findPairRank() {
    int[] freq = new int[13];
    for (Card c: cards) { //assuming you use Card objects
        freq[c.getRank()]++;
    }

    for (int i = 12; i >= 0; i--) {
        if (freq[i] == 2) return i;
    }
    return -1; //no pair found
}