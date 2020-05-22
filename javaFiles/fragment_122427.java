public class IndexLocker {

    private static AtomicInteger index = new AtomicInteger(0);

    private final static int batchSize = 1000;

    public IndexLocker() {

    }

    public static int getAllowedListSize() {
        return batchSize;

    }

    public static synchronized void incrmntIndex(int hop) {
        index.getAndAdd(hop);
    }

    public static synchronized int getAvailableIndex() {

        int result = index.get();
        index.getAndAdd(batchSize);
        return result;
    }

}