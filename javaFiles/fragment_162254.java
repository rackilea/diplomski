public static void main(final String[] args) throws IOException, InterruptedException {
    final Counter t1 = new Counter(1, 5, null);
    final Counter t2 = new Counter(6, 8, t1);
    t1.start();
    t2.start();
}