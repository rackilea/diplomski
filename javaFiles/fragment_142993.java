do
{
   if (newDeck[element]== null)
   {
       newDeck[element]=deck[index];
   }
   else
   {
    element = (int) (Math.random()*52);
   }
}while(newDeck[element]!=null);