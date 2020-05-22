public static int[] compression(int[] array){
      int j = 0;
      // iterate over all the numbers in the array.
      for (int i : array)
          // if the number is not 0 add it back into the array
          if (i != 0)
              // add it back only counting non-0 for the index
             array[j++] = i;
      // fill the rest of the array with zero.
      Arrays.fill(array, j, array.length, 0);
 }