public void sortArray()
{
   boolean sorted;

   do
   {
       sorted = true;  // Assume it's sorted
       for(int i = 0; i < inArray.length - 1; i++)
       {
          if(inArray[i] > inArray[i + 1])
          {
             int temp = inArray[i];
             inArray[i] = inArray[i + 1];
             anArray[i + 1] = temp;
             sorted = false; // We changed something, so assume we need to do another pass
          }
       }
   }
   while (!sorted);
}