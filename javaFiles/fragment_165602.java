public static int[] farthestK(Integer[] a, final int val, int k) {
    Arrays.sort(a, new java.util.Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Math.abs(o1 - val) + Math.abs(o2 - val);
        }
    });
    int[] c = new int[k];
    for (int i = 0; i < k; i++) {
        c[i] = a[i];
    }
    return c;
}