public class MyCallable implements Callable<Boolean> {

    @Override
    public Boolean call() {
        // Do some job and return the result.
        return Boolean.TRUE;
    }
}