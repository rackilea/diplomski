public class NamedPredicate<T> implements Predicate<T> {
    private final String name;
    private final Predicate<T> predicate;

    public NamedPredicate(String name, Predicate<T> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    @Override
    public boolean test(T t) {
        return predicate.test(t);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String... args) {
        Predicate<Integer> isEven = new NamedPredicate<>("isEven", i -> i % 2 == 0);
        System.out.println(isEven); // prints isEven
    }
}