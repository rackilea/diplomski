public interface Operation<T> {
    T execute();
}

public class Executor {
    //...
    public <T> T execute(final Operation<T> operation) {
        log.debug("something");
        try {
            final T result = operation.execute();
            log.debug(result);
            return result;
        } catch (final Exception e) {
            log.error("error", e);
            throw new RuntimeException("omg", e);
        }
    }
}