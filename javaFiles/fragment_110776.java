public class FindMemoryUsage {
    public static void main(String[] args) {
        for (int i=0; i<50; i+=2) {
            long actual = getActualUsageForN(i);
            System.out.println(i + " = " + actual);
            long theoretical = getTheoreticalUsageForN(i);
            if (theoretical != actual) {
                throw new RuntimeException("Uh oh! Mismatch!");
            }
        }
    }

    private static long getTheoreticalUsageForN(long count) {
        long optimal = (Unsafe.ARRAY_BYTE_BASE_OFFSET + Unsafe.ARRAY_BYTE_INDEX_SCALE * count);
        return ((optimal - 1) & ~7) + 8;
    }

    private static long getActualUsageForN(int count) {
        System.gc();
        byte[][] arrays = new byte[3000000][];
        long begin = usedMemory();
        for (int i=0; i<arrays.length; i++) {
            arrays[i] = new byte[count];
        }
        long end = usedMemory();
        return Math.round((end - begin) / (double) arrays.length);
    }

    private static long usedMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}