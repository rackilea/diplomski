Random generator = new Random();
int currentCard;
int nextCard = generator.nextInt( KING+1 );
while (correctGuesses < 4)
{
    currentCard = nextCard;
    nextCard = generator.nextInt( KING+1 );
    ...
}