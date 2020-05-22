Scanner sc = new Scanner(System.in);
try {
    while (!sc.hasNextBoolean()) {
        if (!sc.hasNextLine()) {
            System.err.println("no input");
            System.exit(1);
        }
        System.err.println("Not a boolean, try again: " + sc.nextLine());
    }
    boolean updown = sc.nextBoolean();
    if (updown) {
        grid[x + 1][y] = grid[x + 2][y] = grid[x + 3][y] = grid[x + 4][y] = 'S';
    } else {
        grid[x][y + 1] = grid[x][y + 2] = grid[x][y + 3] = grid[x][y + 4] = 'S';
    }
    drawGrid(grid);
} catch (InputMismatchException ime) {
    System.err.println("Expected true or false.");
    System.err.println(ime.getMessage());
    ime.printStackTrace(System.err);
}