public abstract class Table<E extends Element> extends ArrayList<E> {
    // implement in concrete subclasses
    public abstract <E1 extends Element> Collector<E1, ?, Table<E1>> collector();
    // Collector<E, ?, Table<E>> collector() is enough if map doesn't have E1 type parameter

    public <E1 extends Element> Table<E1> map(Function<E, E1> mapper) {
        return this.stream().map(mapper).collect(collector());
    }

    public Table<E> filter(Predicate<E> predicate) {
        return this.stream().filter(predicate).collect(collector());
    }
}

public class ChildTable<E extends Element> extends Table<E> {
    @Override
    public <E1 extends Element> Collector<E1, ?, Table<E1>> collector() {
        return Collectors.toCollection(() -> new ChildTable<E1>());
        // or simpler Collectors.toCollection(ChildTable::new);
    }
}