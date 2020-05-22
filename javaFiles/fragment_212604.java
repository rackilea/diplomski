@FunctionalInterface
public interface Transformation2<A, B> extends Transformation {

    void execute(A a, B b);

    @Override
    @SuppressWarnings("unchecked")
    default void executeVariadic(Object... args) {
        this.execute((A) args[0], (B) args[1]);
    }
}