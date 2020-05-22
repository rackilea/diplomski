public static int rightSearch(int a[], int key, int l, int h) {
  if (l<=h) {
    int mid = (l+h)/2;
    if (a[mid] == key) {
      if (mid<h && a[mid+1] == key) {
        return rightSearch(a, key, mid + 1, h);
      } else {
        return mid;
      }
    }
    if (a[mid] > key) {
      return rightSearch(a, key, l, mid-1);
    } else {
      return rightSearch(a, key, mid+1, h);
    }
  }
  return -1;
}