@FunctionalInterface
public interface ThrowingFunction<T,R> extends Function<T,R> {

    @Override
    public default R apply(T t) {
        try {
            return throwingApply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static<T,R> Function<T,R> wrap(ThrowingFunction<T,R> f) {
        return f;
    }

    R throwingApply(T t) throws Exception;
}