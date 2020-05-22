public static void startRecursion(int target, int[] numbers) {
  int min = numbers[0];
  for (int i = 1; i < numbers.length; ++i) {
    min = Math.min(min, numbers[i]);
  }
  // We need to choose at most ceil(target / min) numbers.
  int maxPicks = (target + min - 1) / min;
  recurse(new int[maxPicks], 0, 0, target, numbers);
}

private static void recurse(
    int[] picked, int numPicked, int sumOfPicked,
    int target, int[] numbers) {
  if (sumOfPicked == target) {
    // We reached the target! Print out the numbers we chose to get here.
    for (int i = 0; i < numPicked; ++i) {
      if (i != 0) System.out.print(" + ");
      System.out.print(picked[i]);
    }
    System.out.println(" = " + target);
  } else if (sumOfPicked < target) {
    // We haven't reached the target yet.
    // Go through each of the numbers that you can choose from numbers
    // in turn, increasing the sum by this amount.
    for (int i = 0; i < numbers.length; ++i) {
      picked[numPicked] = numbers[i];
      recurse(
          picked, numPicked + 1, sumOfPicked + numbers[i],
          target, numbers);
    }
  } else {
    // We have overshot the target. Since no numbers are negative,
    // we can't get back to the target again.
  }
}