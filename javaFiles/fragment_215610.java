public static void main(String... args) {
    Scanner kybd = new Scanner(System.in);
    System.out.println("Enter a number that is between 1 and 9 (inclusive): ");

    int rows = kybd.nextInt(); // this is the value that the user will enter for # of rows

    for (int i = -rows + 1; i < rows; i++) {
        for (int j = -rows; j < 0; j++)
            System.out.print(abs(i) > j + rows ? "   " : String.format("%3d", j * j));
        System.out.println();
    }
}