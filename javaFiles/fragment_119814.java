public static void printQueens(int[] q) {
    int[] adjusted = new int[q.length];
    for (int i = 0; i < q.length; ++i) {
         adjusted[i] = q[i] + 1;
    }
    System.out.println(Arrays.toString(adjusted));
}