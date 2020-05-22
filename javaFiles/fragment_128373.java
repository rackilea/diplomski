public int addStrange(int n) {
    if (n <= 0) {
        return 0;
    }
    return n + addStrange(n - 2);
}