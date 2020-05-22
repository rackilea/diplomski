private static String[] deck = new String[52];

static {
    for (int i = 0; i < deck.length; i++)
    {
        deck[i] = rank[i % 13] + " of " + suit[i / 13];
        System.out.println(deck[i]);
    }
}