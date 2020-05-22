import java.util.*;


 class TestClass
{
public static void main(String args[]) throws Exception {

    Scanner sc = new Scanner(System.in);
    int numberOfTests = sc.nextInt();
    int cost = 0;
    for (int i = 0; i < numberOfTests; i++) // scanning no. of test cases
    {
      int arraySize = sc.nextInt(); // scanning no. of elements
      int[] array = new int[arraySize];
      for (int j = 0; j < arraySize; j++) {
        array[j] = sc.nextInt();
      }

      while (array.length > 2) {
        cost = cost + getResultForLocation(array, 1);
        array = reduceArray(array, 1);
      }
    }

    System.out.println(cost);
  }

  static int getResultForLocation(int[] array, int location) {

    int cost = 0;
    if (location > 0 && location < array.length - 1) {
      // logic part
      cost = cost + (array[location] * array[location - 1]) + (array[location] * array[location + 1]) + (array[location - 1] * array[location + 1]);
    }
    return cost;
  }

  static int[] reduceArray(int[] array, int locationToRemove) {

    if (array == null || array.length <= 2) {
      return array;
    }
    if (locationToRemove == array.length) {
      return array;
    }
    int[] returnArray = new int[array.length - 1];
    for (int i = 0; i < locationToRemove; i++) {
      returnArray[i] = array[i];
    }
    for (int i = locationToRemove; i < array.length - 1; i++) {
      returnArray[i] = array[i + 1];
    }
    return returnArray;