public static boolean allPositive (double[] arr) {
  for (int i = 0; i < arr.length; i++) {
    if(arr[i] < 0)
    {
        return false;
    }
  }
  return true;
}