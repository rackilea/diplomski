for (f = 0; f < array.length; f++) {
  for (l = array.length - 1; l > f; l--) {
    if (array[f] < array[l]) {
      temp = array[l];
      array[l] = array[f];
      array[f] = temp;
      System.out.println(Arrays.toString(array));
    }
  }
}