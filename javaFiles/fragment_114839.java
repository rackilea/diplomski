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