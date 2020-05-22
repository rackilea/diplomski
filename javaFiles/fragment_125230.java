public static void main(String[] args) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
        doSort();
    }
    long elapsed = System.currentTimeMillis() - start;
    long average = elapsed / 10;
}