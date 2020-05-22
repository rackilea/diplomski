public interface BatchSynchronisedPool<R extends Runnable, C extends Callable> {
    void execute(R runnable, Object batchIdentifier);
    public <T> Future<T> submit(Class<T> cls, C callable, Object batchIdentifier);
}

public class MyBSP<R, C> implements BatchSynchronisedPool<R, C> {
    void execute(R runnable, Object batchIdentifier) { ... }
    public <T> Future<T> submit(Class<T> cls, C callable, Object batchIdentifier) {
        // Do work... with a cast.
        T result = cls.cast(callable.call());

        ...
    }
}

public class MyUsageClass {
     public static void main(String[] args) {
         // Submit string.
         MyBSP<Runnable, Callable> bsp = new MyBSP<Runnable, Callable>();
         bsp.submit(new StringCallable(), someObject1);

         // Submit integer.
         bsp.submit(new IntegerCallable(), someObject2);
     }
}