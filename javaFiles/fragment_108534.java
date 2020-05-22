class Z {

    private static final class Wrapper<T extends A & IB> {

        private final T item;

        Wrapper(final T item) {
            this.item = item;
        }

        void doWork() {
            // code thats requires facilities from A and IB
        }
    }

    private List<Wrapper<?>> wrappers;

    private <T extends A & IB> void subscribe(T item) {
        wrappers.add(new Wrapper<T>(item));
    }
    public void doSomethingWithItems() {
        for (final Wrapper<?> wrapper : wrappers) {
            wrapper.doWork();
        }
    }