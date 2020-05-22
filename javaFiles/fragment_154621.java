public static final int N = 10;

public void main(String[] args) {
    int[][] a = new int[N][N];
    int n = /* Read number from the user */;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            a[i][j] = i; // Bug - we meant to initialize to n
        }
    }

    // ...
}