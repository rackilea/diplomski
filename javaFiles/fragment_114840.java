public static void main(String... args) {
    try (Scanner scan = new Scanner(System.in)) {
        System.out.print("Height: ");
        int height = scan.nextInt();

        System.out.print("Width: ");
        int width = scan.nextInt();

        System.out.println(calcSumPath(height, width));
    }
}

private static long calcSumPath(int height, int width) {
    long sumPath = ZERO;
    int row = 0;

    while (row < height - 1) {
        for (int col = 1; col < width; col++)
            sumPath += get(col % 2 == 0 ? row : row + 1, col);

        row += 2;

        if (row >= height)
            break;

        for (int col = width - 2; col >= 0; col--)
            sumPath += get(col % 2 == 0 ? row : row - 1, col);
    }

    return sumPath;
}

private static final int ZERO = 1;
private static final int OFFS = 3;
private static final Map<Integer, Map<Integer, Integer>> MAP = new HashMap<>();

public static int get(int row, int col) {
    Map<Integer, Integer> values = MAP.computeIfAbsent(row, k -> new HashMap<>());

    if (!values.containsKey(col)) {
        int val = ZERO;

        for (int i = 0; i < row; i++)
            val += OFFS;

        for (int i = 0; i < col; i++)
            val += OFFS;

        values.put(col, val);
    }

    return values.get(col);
}