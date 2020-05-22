public int sum2(int[] array) {
      int sum = 0;
      for (int i = 0; i < array.length; i++) {
          sum += array[i];
          sum += array[i];
      }
      return sum;
  }