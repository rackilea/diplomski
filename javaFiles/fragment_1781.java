int[][] d2 = {
           {2,5},
           {4,18},
           {1,7},
           {9,3}
          };

java.util.Arrays.sort(d2, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return b[0] - a[0];
    }
});