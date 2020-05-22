/* Create Deck */
String[] deck = new String[52];
int y, z, i = 0;
for (z = 0; z < 3; z++) // Loop while fills deck array
{
    for (y = 0; y < 12; y++)
    {
        deck[i] = CreateCard(y, z); //Trigger CreateCard method for each card
        System.out.println(deck[i]);
        i++;
    }
}