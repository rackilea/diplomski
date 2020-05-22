@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other){
        //return t -> this.test(t) && other.test(t);
        return new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return Predicate.this.test(t) && other.test(t);
            }
        };
    }
}