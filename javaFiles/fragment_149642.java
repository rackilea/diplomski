public static void main(String[] args) {
    boolean[][] ret = new boolean[5][5];
    boolean[] tofill = new boolean[] { true, true, true, true, true };

    Arrays.fill(ret, tofill);

    for (boolean[] arr : ret) {
        System.out.println(Arrays.toString(arr));
    }
}