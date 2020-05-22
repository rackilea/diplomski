public static void triangle(int n) {
    int[][] triangle = new int[n];
    for (int i = 0; i < n; i++) {
        triangle[i] = new int[i+1];
    }
    triangle[0][0] = 1;
    triangle[1][0] = 1;
    triangle[1][1] = 1;
    for (int i = 2; i < n; i++) {
        triangle[i][0] = 1;
        for (int j = 1; j < triangle[i].length - 1; j++) {
            triangle[i][j] = triangle[i-1][j] + triangle[i-1][j+1];
        }
        triangle[i][triangle[i].length-1] = 1;
    }
    printArray(triangle);
}