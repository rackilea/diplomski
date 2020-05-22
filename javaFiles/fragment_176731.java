public static int solution3(int arrayMaxValue, int[] myArray) {
    int result = -1;
    boolean b[] = new boolean[arrayMaxValue + 1];
    for (int i = 0; i < myArray.length && result == -1; i++) {
      arrayMaxValue = b[myArray[i]] ? arrayMaxValue : arrayMaxValue - 1;
      b[myArray[i]] = true;
      result = (arrayMaxValue == 0) ? i : result;
    }
    return result;
  }