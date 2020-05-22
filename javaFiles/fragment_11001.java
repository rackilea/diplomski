public static void main(String... args) {
    ByteBuffer bb1 = ByteBuffer.allocateDirect(256 * 1024).order(ByteOrder.nativeOrder());
    ByteBuffer bb2 = ByteBuffer.allocateDirect(256 * 1024).order(ByteOrder.nativeOrder());
    for (int i = 0; i < 10; i++)
        runTest(bb1, bb2);
}

private static void runTest(ByteBuffer bb1, ByteBuffer bb2) {
    bb1.clear();
    bb2.clear();
    long start = System.nanoTime();
    int count = 0;
    while (bb2.remaining() > 0)
        bb2.putInt(bb1.getInt());
    long time = System.nanoTime() - start;
    int operations = bb1.capacity() / 4 * 2;
    System.out.printf("Each putInt/getInt took an average of %.1f ns%n", (double) time / operations);
}