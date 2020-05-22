int randomNum;
int i;
for(i=0;i<DECK_SIZE;i++)
{
    randomNum = randomGen.nextInt(DECK_SIZE);
    tempCard = deck[i];
    deck[i] = deck[randomNum];
    deck[randomNum] = tempCard;
}//end for.