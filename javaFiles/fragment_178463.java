public class Answer {

  public static void main(String[] args) {
    int[] unsorted = new int[]{4,3,4,2,1,1,3,3,3,3,3,5,6,6,9,9,10,7,7,8};
    System.out.println(Arrays.toString(mergeSort(unsorted)));
  }

  public static int[] mergeSort(int[]a) {
    if (a.length == 1) return a;

    int[] q = new int[a.length];
    int[] l = new int[a.length / 2];
    int [] r = new int[a.length - l.length];

    for (int i = 0; i < l.length; i++) {
      l[i] = a[i];
    }

    for (int i = 0; i < r.length; i++) {
      r[i] = a[l.length + i];
    }

    q = merge(mergeSort(l), mergeSort(r));
    return q;
  }

  private static int[] merge(int[]a, int[]b) {
    int length = a.length + b.length;
    int[] c = new int[length];
    int p = 0;
    while (a.length > 0 && b.length > 0) {
      if (a[0] < b[0]) {
        c[p++] = a[0];
        a = tail(a);
      } else {
        c[p++] = b[0];
        b = tail(b);
      }
    }
    while (a.length > 0) {
       c[p++] = a[0];
       a = tail(a);
    }
    while (b.length > 0) {
       c[p++] = b[0];
       b = tail(b);
    }
    return c;
  }

  private static int[] tail(int[] a) {
    int[] t = new int[a.length - 1];
    for (int i = 0; i < t.length; i++) {
      t[i] = a[i + 1];
    }
    return t;
  }
}