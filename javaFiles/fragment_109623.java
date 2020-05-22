public static boolean bstIterate(int array[], int start, int end, int depth) {
  if (end <= start)
    return false;
  else {
    int mid = start + (end-start)/2;
    if (depth == 0) {
      System.out.println(array[mid]);
      return true;
    }
    else {
      boolean res1 = bstIterate(array, start, mid, depth-1);
      boolean res2 = bstIterate(array, mid+1, end, depth-1);
      return res1 || res2;
    }
  }
}