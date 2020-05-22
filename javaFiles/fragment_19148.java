public static int[] merge(int[] arr1, int[] arr2) {
  if (arr1 == null && arr2 == null) return null;
  if (arr1 == null) return arr2.clone();
  if (arr2 == null) return arr1.clone();       

  int[] result = new int[arr1.length + arr2.length];
  int i = 0, j = 0, r = 0;
  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] < arr2[j]) {
      result[r] = arr1[i];
      i++;
    } else {
      result[r] = arr2[j];
      j++;
    }
    r++;
  }
  // Copy the remaining elements in array 1 to result
  if (i < arr1.length) {
    System.arraycopy(arr1, i, result, r, (arr1.length - i));
  }
  // Copy the remaining elements in array 2 to result
  if (j < arr2.length) {
    System.arraycopy(arr2, j, result, r, (arr2.length - j));
  }
  return result;
}