public static int sum(int... elements) {
    int total = 0;
    for (int element : elements) {
        total += element;
    }
    return total;
}