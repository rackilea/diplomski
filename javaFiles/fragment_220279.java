public int addHand()
{
   int j=0;
   for(int i=0; i<=counter-1; i++)
   {
      Card c = Cards[i];
      if(c != null)
         j += Cards[i].getValue();
      else
         System.out.println("Add hand was trying to add a null card for index = " + i);
   }
   return j;
}