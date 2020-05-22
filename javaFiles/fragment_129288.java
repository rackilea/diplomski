Scanner sc = new Scanner(data).useDelimiter("[,|]");
    final int M = 3;
    final int N = 2;
    String[][] matrix = new String[M][N];
    for (int r = 0; r < M; r++) {
        for (int c = 0; c < N; c++) {
            matrix[r][c] = sc.next();
        }
    }
    System.out.println(Arrays.deepToString(matrix));
    // prints "[[1, apple], [2, ball], [3, cat]]"