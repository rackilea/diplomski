public static void main(String[] args) throws Exception {
    final class PrintMe implements Callable<Void> {

        final String toPrint;

        public PrintMe(final String toPrint) {
            this.toPrint = toPrint;
        }

        @Override
        public Void call() throws Exception {
            System.out.println(toPrint);
            return null;
        }

    }
    final List<Callable<Void>> callables = new LinkedList<>();
    for (int i = 0; i < 10; ++i) {
        callables.add(new PrintMe("I am " + i));
    }
    final ExecutorService es = Executors.newFixedThreadPool(4);
    es.invokeAll(callables);
    es.shutdown();
    es.awaitTermination(1, TimeUnit.DAYS);
}