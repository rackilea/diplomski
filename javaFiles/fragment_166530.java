public class RetryableCallable<T> implements Callable<T> {
    private int retries = 3;

    @Override
    public T call() throws Exception {
        while (retries-- > 0) {
            try {
                return callable.call();
            } catch (InterruptedException e) {
                LOGGER.error("Callable: " + callable.toString() + " was interrupted");
                throw e;
            } catch (TimeoutException e) {
                LOGGER.warn("Callable: " + callable.toString() + " timed out after " + timeout + " " + timeUnit);
                throw e;
            } catch (Exception e) {
                LOGGER.warn("Callable: " + callable.toString() + " failed");
            }
        }
        throw new IllegalStateException();//or return null
    }
}