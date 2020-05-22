long start = System.currentTimeMillis();
try {
    final List<int[]> memoryGrave = new ArrayList<>();
    while (true) {
        memoryGrave.add(new int[Integer.MAX_VALUE - 5]);
    }
} finally {
    System.out.println(System.currentTimeMillis() - start);
}