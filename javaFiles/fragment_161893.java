public static int leftSearch(int a[], int key, int l, int h) {
  if (l<=h) {
    int mid = (l+h)/2;
    if (a[mid] == key) {
      if (mid > 0 && a[mid-1] == key) {
        return leftSearch(a, key, l, mid-1);
      } else {
        return mid;
      }
    }
    if (a[mid] > key) {
      return leftSearch(a, key, l, mid-1);
    } else {
      return leftSearch(a, key, mid+1, h);
    }
  }
  return -1;
}