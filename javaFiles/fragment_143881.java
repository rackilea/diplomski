public interface BatchSynchronisedPool<R extends Runnable> {
    void execute(R runnable, Object batchIdentifier);
    public <T> Future<T> submit(Callable<T> callable, Object batchIdentifier);
}

public class MyBSP<R, C> implements BatchSynchronisedPool<R, C> {
    void execute(R runnable, Object batchIdentifier) { ... }
    public <T> Future<T> submit(Callable<T> callable, Object batchIdentifier) {
        // Check types.
        if (!(callable instanceof MyDesiredCallableClass)) {
            throw new IllegalArgumentException("Types don't match.");
        }

        // Do work.
        T result = callable.call();

        ...
    }
}

public class MyUsageClass {
     public static void main(String[] args) {
         // Submit string.
         MyBSP<Runnable> bsp = new MyBSP<Runnable>();
         bsp.submit(new StringCallable(), someObject1);

         // Submit integer.
         bsp.submit(new IntegerCallable(), someObject2);
     }
}