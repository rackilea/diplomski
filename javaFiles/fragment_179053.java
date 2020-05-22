String input = "3 5\n" +
               "4 5 6\n" +
               "12 34 12 12 8\n" +
               "34 23\n" +
               "12 34 34 10 89\n";
Scanner in = new Scanner(input);
final int rows = in.nextInt();
final int cols = in.nextInt();
int[][] matrix = new int[rows][cols];
int row = 0, col = 0;
for (int i = 0; i < rows * cols; i++) {
    matrix[row][col] = in.nextInt();
    if (++col == cols) {
        row++;
        col = 0;
    }
}
System.out.println(Arrays.deepToString(matrix));