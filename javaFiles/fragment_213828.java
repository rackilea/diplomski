public int add(int... values) {
    int sum = 0;
    for (int value : values) {
        sum += value;
    }
    return sum;
}