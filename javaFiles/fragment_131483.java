public static int duplicates(int[] array)
{
   int numberOfPairs = 0;

   Arrays.sort(array);
   for (int k = 0; k < array.length - 1; k++) 
   {
       if (array[k] == array[k + 1])
       {
           numberOfPairs++;
           k++;
       }
   }
   return numberOfPairs;
}