public Deck()
{
        for(int i = 0; i < 13; i++)
        {
              for(int j = 0; j < 4; j++)
              {
                 index = (i * 4) + j;
                 if(i < 9)
                     card[index] = new Card(Integer.toString(2+i), j);
                 else if(i == 9)
                     card[index] = new Card("J", j);
                 else if(i == 10)
                     card[index] = new Card("Q", j);
                 else if(i == 11)
                     card[index] = new Card("K", j);
                 else
                     card[index] = new Card("A", j);
              }
        }
}