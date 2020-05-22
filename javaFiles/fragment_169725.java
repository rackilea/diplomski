deck = shuffleDeck(deck, N);

// print shuffled deck
for ( int i=0; i<N;) 
{

    //checking for invalid char at index 0
    if(i == 0 && (deck[i].charAt(0) == 'K' || deck[i].charAt(0) == 'A' || deck[i].charAt(0) == '2' || deck[i].charAt(0) == 'Q'))
    {
         System.out.println("Invalid first card.");
         shuffleDeck(deck, N);
    }
    else
    {
         System.out.println(deck[i]);
         i++;
    }
}
}

private static String[] shuffleDeck(String[] deck, int N)
{
    // shuffle
    for (int i=0; i<N; i++) 
    {
        int r = i + (int)(Math.random()*(N-i));
        String t = deck [r];
        deck[r] = deck [i];
        deck[i] = t;
    }
return deck;
}