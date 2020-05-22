class StatefulPredicate<T> implements Predicate<T> {

    private boolean alreadyFiltered;
    private Predicate<T> pred;

    public StatefulPredicate(Predicate<T> pred) {
        this.pred = pred;
        this.alreadyFiltered = false;
    }

    @Override
    public boolean test(T t) {
        if(alreadyFiltered) {
            return true;
        }

        boolean result = pred.test(t);
        alreadyFiltered = !result;
        return result;
    }
}

    Stream.of(1, -1, 3, -4, -5, 6)
        .filter(new StatefulPredicate<>(i -> i > 0))
        .forEach(System.out::println);