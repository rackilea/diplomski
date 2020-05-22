public static void displayPattern(int n) {
    // Create pyramid of numbers with increasing order
    for (int i = 1; i <= n; i++) {
        for (int j = n; j > 0; j--) {
            if (j > i) {
                System.out.print("  ");
            } else {
                System.out.print(" " + j);
            }
        }
        System.out.print("\n");
    }
}