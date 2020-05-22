public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
        for (int i = 0, T = scan.nextInt(); i < T; i++) {
            int N = scan.nextInt();
            int sum = 0;

            for (int j = 0; j < N; j++)
                sum = (int)(scan.nextLong() % N + sum) % N;

            System.out.println(N == 0 ? "YES" : "NO");
        }
    }
}