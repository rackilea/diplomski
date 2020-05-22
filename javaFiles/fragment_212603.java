@FunctionalInterface
public interface Transformation1<A> extends Transformation {

    void execute(A a);

    @Override
    @SuppressWarnings("unchecked")
    default void executeVariadic(Object... args) {
        this.execute((A) args[0]);
    }
}