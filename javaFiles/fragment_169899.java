PlayingCard[] cardDeck = new PlayingCard[52];

int i = 0;
while(rank < 15)
    {
        cardDeck[i++] = new PlayingCard(rank, suit);
    }