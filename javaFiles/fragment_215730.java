public static int binarySearch(int[] arr, int v) {
  int lo = -1;
  int hi = arr.length - 1;

  while (hi - lo > 1 ) {
    int middle = (lo + hi) / 2;
    if (arr[middle] > v) {
      lo = middle;
    } else {
      hi = middle;
    }
  }

  if (v == arr[hi]) {
    return hi;
  } else {
    return -1;
  }
}