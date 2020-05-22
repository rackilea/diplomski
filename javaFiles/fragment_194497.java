public boolean[] solve(int[] values, int[] costs, int capacity) {
    boolean take[] = new boolean[values.length];
    int min_cost = Integer.MAX_VALUE;
    for (int i = 0; i < values.length; i++) {
        if (costs[i] < min_cost) {
            min_cost = costs[i];
        }
    }
    int table[][] = new int[values.length][capacity + 1 - min_cost];
    for (int i = 0; i < values.length; i++) {
        int v = values[i];
        int w = costs[i];
        for (int j = 0; j < capacity - min_cost + 1; j++) {
            int prev_value = 0;
            int new_value = 0;
            if (i > 0) {
                prev_value = table[i - 1][j];
                if (w <= j + min_cost) {
                    if (w <= j) {
                        new_value = table[i - 1][j - w] + v;
                    } else {
                        new_value = v;
                    }
                }
            } else if (w <= j + min_cost) {
                new_value = v;
            }
            table[i][j] = Math.max(prev_value, new_value);
        }
    }
    int index = capacity - min_cost;
    for (int i = values.length - 1; i > 0 && index >= 0; i--) {
        if (table[i][index] != table[i - 1][index]) {
            take[i] = true;
            index -= costs[i];
            if (index < 0) {
                System.err.println("index = " + index);
            }
        } else {
            take[i] = false;
        }
    }
    take[0] = index >= 0 && table[0][index] != 0;
    return take;
}