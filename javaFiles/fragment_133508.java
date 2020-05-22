private static void findSubsets(int array[], int i, int j)
   {
      int arrayLen = j - i + 1;
      int numOfSubsets = 1 << (arrayLen - 1);

      for (int k = 1; k < numOfSubsets; k++)
      {
         int pos = j;
         int bitmask = k;

         System.out.print("{");
         while (bitmask > 0)
         {
            if ((bitmask & 1) == 1)
               System.out.print(array[pos] + ",");
            bitmask >>= 1;
            pos--;
         }
         System.out.print("}");
      }
   }