public static void main(String[] args) {
    // args[0] - Full path of the file
    final boolean[][] open = readOpenFromFile(args[0]);
    print(flow(open));
    System.out.println(percolates(open));
}

public static boolean[][] readOpenFromFile(String filepath) {
    final File f = new File(filepath);
    try {
        scan = new Scanner(f);
    }
    catch(FileNotFoundException ex) {
        System.exit(0);
    }

    final int m = scan.nextInt();
    final int n = scan.nextInt();
    final boolean[][] grid = new boolean[m][n];

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            grid[i][j] = readBoolean();
        }
    }
    return grid;
}