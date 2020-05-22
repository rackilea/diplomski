private int min(int[] data) {
    int min = Integer.MAX_VALUE; // handy constant :)
    for (int i = 0; i < data.length; i++) {
        if (data[i] < min) {
            min = data[i];
        }
    }
    return min;
}

private int max(int[] data) {
    int max = 0;
    for (int i = 0; i < data.length; i++) {
        if (data[i] > max) {
            max = data[i];
        }
    }
    return max;
}