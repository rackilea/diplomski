for (int i = deck.length-1; i > 0; i--) {
    int j = rand.nextInt(i+1);
    int temp = deck[i];
    deck[i] = deck[j];
    deck[j] = temp;
}