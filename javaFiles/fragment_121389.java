public static void main(String[] args) {
    String input = "3\n" +
            "1 2 3\n" +
            "3 4 5\n" +
            "6 9 3\n";
    Scanner scanner = new Scanner(input);

    int rows = scanner.nextInt();
    scanner.nextLine();

    int[][] arr = new int[rows][];

    for (int i = 0; i < rows; ++i) {
        String line = scanner.nextLine();
        arr[i] = lineToIntArray(line);
    }
}

private int[] lineToIntArray(String line) {
    String[] cols = line.split(" ");
    int[] ints = new int[cols.length];
    for (int i = 0; i < cols.length; ++i) {
        ints[i] = Integer.parseInt(cols[i]);
    }
    return ints;
}