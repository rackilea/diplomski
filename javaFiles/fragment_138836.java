public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[][] = new int[n][n];
    int sum = 0, sum1 = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = in.nextInt();

            // primary diagonal
            if (i == j) {
                sum += a[i][j];
            }

            // secondary diagonal
            if (i == n - j - 1) {
                sum1 += a[i][j];
            }
        }
    }
    System.out.println(Math.abs(sum - sum1));
}