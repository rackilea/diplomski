class Task {}

class Assertion extends Task {}

abstract class TaskCollection<E extends Task, C extends TaskCollection<E, C>> extends HashSet<E> {

    <K> Map<K, C> groupBy(Function<E, K> groupingFunction) {
        return this.stream()
            .collect(Collectors.groupingBy(
                    groupingFunction,
                    Collectors.toCollection(this.collectionSupplier())
            ));
    }

    protected abstract Supplier<C> collectionSupplier();
}

class AssertionCollection extends TaskCollection<Assertion, AssertionCollection> {

    @Override
    protected Supplier<AssertionCollection> collectionSupplier() {
        return AssertionCollection::new;
    }
}