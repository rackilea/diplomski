public void shuffle() {
    for (int i = deck.length - 1; i >= 0; i--)
    {
        index = r.nextInt(i + 1);
        Card temp = deck[index];
        deck[index] = deck[i];
        deck[i] = temp;
    }
    current = 0;
}