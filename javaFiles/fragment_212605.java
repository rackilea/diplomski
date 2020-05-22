@FunctionalInterface
public interface Transformation3<A, B, C> extends Transformation {

    void execute(A a, B b, C c);

    @Override
    @SuppressWarnings("unchecked")
    default void executeVariadic(Object... args) {
        this.execute((A) args[0], (B) args[1], (C) args[2]);
    }
}