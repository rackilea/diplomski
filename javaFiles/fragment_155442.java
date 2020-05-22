final class SystemOutConsumer<A> implements Consumer<A> {

    private final BiConsumer<PrintStream, A> printStreamABiConsumer;

    public SystemOutConsumer(
            final BiConsumer<PrintStream, A> printStreamABiConsumer) {

        this.printStreamABiConsumer = printStreamABiConsumer;
    }

    public void accept(final A a) {

        printStreamABiConsumer.accept(System.out, a);
    }
}