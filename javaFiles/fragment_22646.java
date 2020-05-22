final int[] array = new int[2 * veryLargeNumber];

public int get(int x, int y) {
    return array[idx(x, y)];
}

public void set(int x, int y, int val) {
    array[idx(x, y)] = val;
}

private int idx(int x, int y) {
    return x * 2 + y; // or x * veryLargeNumber + y;
}