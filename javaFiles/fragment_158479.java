class Accumulator {
  static int binarySum(int a[]) {
    return binarySum(a, 0, a.length-1);
  }

  static int binarySum(int a[], int s, int e) {
    if (e-s == 0) return a[s];
    int mid = s + ((e-s)/2);
    return binarySum(a, s, mid) + binarySum(a, mid+1, e);
  }

  public static void main(String args[]) {
    int[] vals = {2,3,4,5,6,7};
    System.out.println(binarySum(vals));
  }
}