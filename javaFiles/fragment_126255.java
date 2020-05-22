//code calculating the smallest number in the array
public static double getSmallest(double[] thenumbers) {

  double smallest = thenumbers[0];

  for (double num : thenumbers) {
    if (num < smallest) {
      smallest = num;
    }
  }

  return smallest;
}