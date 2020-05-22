public static void main(String args[]) {
    // store your puzzle in puzzle variable.
    int puzzle[][] = {
        {0, 9, 0, 0, 0, 0, 0, 0, 8},
        {0, 0, 3, 2, 0, 7, 0, 9, 0},
        {0, 6, 0, 0, 0, 0, 7, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 6},
        {0, 0, 5, 4, 3, 2, 1, 0, 0},
        {4, 0, 0, 7, 0, 0, 0, 0, 0},
        {0, 0, 7, 0, 0, 0, 0, 3, 0},
        {0, 2, 0, 9, 0, 8, 6, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 4, 0}
    };
    testHorizontal(puzzle);
    testVertical(puzzle);
}

public static void testHorizontal(int[][] puzzle) {
    for (int[] arr : puzzle) {
        test(arr);
    }
}

public static void testVertical(int[][] puzzle) {
    int[] cols = new int[puzzle.length];
    for (int i = 0; i < puzzle.length; i++) {
        for (int j = 0; j < puzzle.length; j++) {
            cols[j] = puzzle[i][j];
            test(cols);
        }
    }
}

public static boolean test(int arr[]) {
    boolean flag = false;
    for (int a : arr) {
        for (int b : arr) {
            if (a == b) {
                flag = true;
                System.out.println("equal numbers found.");
                break;
            }
        }
    }
    return flag;
}