// Return max number in array which is lower than ceilValue
// Return Integer.MIN_VALUE if no such value found
public static int maxValueBelow(int[] array, int ceilValue) {
   int max = Integer.MIN_VALUE;
   for (int i = 0; i<array.length; i++) {
       if (array[i] < ceilValue && array[i] > max) {
         max = array[i];
       }
   }
   return max;
}

public static int findNthValue(int[] array) {
  int maxValue = maxValueBelow(array, Integer.MAX_VALUE);
  int secondMaxValue = maxValueBelow(array, maxValue);
  int thirdMaxValue = maxValueBelow(array, secondMaxValue);
  // You can improve this function by give it's a second parameter `n`, and use for loop to find the `n-th` max value.
}