public static void main(String[] args) {
    int[][] table = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };

    // This code assumes all rows have same number of columns
    int[][] pivot = new int[table[0].length][];
    for (int row = 0; row < table[0].length; row++)
        pivot[row] = new int[table.length];

    for (int row = 0; row < table.length; row++)
        for (int col = 0; col < table[row].length; col++)
            pivot[col][row] = table[row][col];

    for (int row = 0; row < pivot.length; row++)
        System.out.println(Arrays.toString(pivot[row]));
}