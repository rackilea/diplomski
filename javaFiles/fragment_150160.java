public Decks(int n) throws PlayingCardException
{
    // implement this method!
    int i, j;
    for (i=0;i<4;i++) 
    {
        for(j=1;j<14;j++) 
        {
            for(k=0;k<n;k++){
                Card orcard = new Card(i,j);
                originalDecks.add(orcard);
                dealDecks.add(orcard);
             }
        }
    }
}