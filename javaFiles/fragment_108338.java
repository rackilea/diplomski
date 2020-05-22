public static boolean isValid(int[] array, int sum) {
    int init = 0,temp = 0;

    for (int i = 0; i < array.length; i++) {
      temp += array[i];
      while (temp > sum) {
        temp -= array[init];
        init++;
      }
      if (temp == sum)
        return true;
    }
    return false;
  }