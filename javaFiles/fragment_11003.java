public static void main(String... args) {
    ByteBuffer bb1 = ByteBuffer.allocateDirect(256 * 1024).order(ByteOrder.nativeOrder());
    ByteBuffer bb2 = ByteBuffer.allocateDirect(256 * 1024).order(ByteOrder.nativeOrder());
    for (int i = 0; i < 10; i++)
        runTest(bb1, bb2);
}

private static void runTest(ByteBuffer bb1, ByteBuffer bb2) {
    Unsafe unsafe = getTheUnsafe();
    long start = System.nanoTime();
    long addr1 = ((DirectBuffer) bb1).address();
    long addr2 = ((DirectBuffer) bb2).address();
    for (int i = 0, len = Math.min(bb1.capacity(), bb2.capacity()); i < len; i += 4)
        unsafe.putInt(addr1 + i, unsafe.getInt(addr2 + i));
    long time = System.nanoTime() - start;
    int operations = bb1.capacity() / 4 * 2;
    System.out.printf("Each putInt/getInt took an average of %.1f ns%n", (double) time / operations);
}

public static Unsafe getTheUnsafe() {
    try {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    } catch (Exception e) {
        throw new AssertionError(e);
    }
}