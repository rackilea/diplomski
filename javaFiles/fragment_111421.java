public static int secondMax(int[] array) {
   int max = Integer.MIN_VALUE; // Max value
   int secondMax = Integer.MIN_VALUE; // Second max value, its our result

   for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        secondMax = max;
        max = array[i];
      } else if (array[i] > secondMax) {
        secondMax = array[i];
      }
   }
   return secondMax;
}