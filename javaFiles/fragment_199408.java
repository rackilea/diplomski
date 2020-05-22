import java.util.Optional;

@FunctionalInterface
public interface Transform<T, R> {
    class AndThen<T, R, S> implements Transform<T, S> {
        final Transform<T, R> first;
        final Transform<R, S> second;

        AndThen(Transform<T, R> first, Transform<R, S> second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public S apply(T t) {
            return second.apply(first.apply(t));
        }

        @Override
        public <U> Optional<Transform<T, U>> decomposeFst() {
            return Optional.of((Transform<T, U>)first);
        }
        @Override
        public <U> Optional<Transform<U, S>> decomposeSnd() {
            return Optional.of((Transform<U, S>)second);
        }

    }

    default <S> Transform<T, S> andThen(Transform<R, S> next) {
        return new AndThen<T, R, S>(this, next);
    }

    R apply(T t);

    default <S> Optional<Transform<T, S>> decomposeFst() {
        return Optional.empty();
    }

    default <S> Optional<Transform<S, R>> decomposeSnd() {
        return Optional.empty();
    }

    static void main(String[] args) {
        final Transform<Double, String> f = Object::toString;
        final Transform<String, Integer> g = String::length;
        final Transform<Double, Integer> h = f.andThen(g);
        final int i = h.apply(1.234);

        final Optional<Transform<Double, String>> f2 = h.<String>decomposeFst();
        final Optional<Transform<String, Integer>> g2 = h.<String>decomposeSnd();

        final String s = f2.get().apply(1.234);
        final int j = g2.get().apply(s);

        System.out.println(s + " : " + j);
    }
}