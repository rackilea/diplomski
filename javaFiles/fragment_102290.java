public Card takeRandomCard() {
    int r;
    do {
        r = (int)(Math.random() * 52);
    } while (taken[r]);
    taken[r] = true;
    return fullDeck[r];
}