public static double run(int i) {
    if (i < 1) {
        return 0;
    }
    return i / (i + 1.0) + run(i - 1);
}