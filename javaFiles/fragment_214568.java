class GetNextNumber {
    private static AtomicLong numberGenerator = new AtomicLong(910000000000L);

    public static long getNext() {
        return numberGenerator.getAndIncrement();
    }
}