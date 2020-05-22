public static void main(String[] args) throws Exception {
    int[][] pairs = {{10, 24}, {10, 25}, {11, 24}, {11, 25}, {10, 27}};
    int m = 5;
    for (int[] pair : pairs) {
        int a = pair[0];
        int b = pair[1];
        int r = (b/m - a/m) + (a % m == 0 ? 1 : 0);
        System.out.printf("a: %d  b: %d  result = %d  ", a, b, r);
        for (int i = a; i <= b; i++) {
            if (i % m == 0) {
                System.out.print(" " + i);
            }
        }
        System.out.println("");
    }
}