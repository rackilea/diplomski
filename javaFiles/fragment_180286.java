class MyClass {
    private static final Predicate STATE_PREDICATE = new Predicate<ITask>() {
        @Override
        public boolean apply(ITask input) {
            // ... your code here
        }
    };

    public ITask getState() {
        return Iterables.find(queue, STATE_PREDICATE, null);
    }
}