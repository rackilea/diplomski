public interface BatchSynchronisedPool<T, R extends Runnable, C extends Callable<T>> {
    void execute(R runnable, Object batchIdentifier);
    public Future<T> submit(C callable, Object batchIdentifier);
}

public class MyBSP<T, R, C> implements BatchSynchronisedPool<T, R, C> {
    void execute(R runnable, Object batchIdentifier) { ... }
    public Future<T> submit(C callable, Object batchIdentifier) {
        // Do work.  Types are okay; no checking or casting needed!
        T result = callable.call();

        ...
    }
}

public class MyUsageClass {
     public static void main(String[] args) {
         // Submit string.
         MyBSP<String, Runnable, Callable<String>> stringBsp = new MyBSP<String, Runnable, Callable<String>>();
         stringBsp.submit(new StringCallable(), someObject1);

         // Submit integer.
         MyBSP<Integer, Runnable, Callable<Integer>> integerBsp = new MyBSP<Integer, Runnable, Callable<Integer>>();
         integerBsp.submit(new IntegerCallable(), someObject2);
     }
}