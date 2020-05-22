public boolean check3InARow(int[] array) {
  int currentResult = (array[0] - 1) / 4;
  int countCurrentResult = 1;
  for (int i=1; i < array.length; i++) {
    if (((array[i] - 1) / 4) == currentResult) {
      countCurrentResult++
      if (countCurrentResult == 3) return true;
    } else {
      currentResult = (array[i] - 1) / 4;
      countCurrentResult = 1
    }
  }
  return false;
}