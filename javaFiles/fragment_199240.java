public interface ExecutionStrategy<T> {
    public T execute(T item);
}


public interface ExecutionStrategyChain<T> extends ExecutionStrategy<T> {
    public static <T> ExecutionStrategyChain<T> newInstance(ExecutionStrategy<T> executionStrategy) {
        return new ExecutionStrategyChainImpl<T>(executionStrategy); 
    }

    public ExecutionStrategyChain<C> chainTo(ExecutionStrategy<C> executionStrategy);
}


public abstract class AbstractExecutionStrategyChain<T> implements ExecutionStrategyChain<T> {
    protected AbstractExecutionStrategyChain() {
        this(null);
    }


    public abstract T execute(T item);


    public ExecutionStrategyChain<T> chainTo(ExecutionStrategy<T> executionStrategy) {
        return new ExecutionStrategyChainImpl<T>(this, executionStrategy);
    }
}


public final class ExecutionStrategyChainImpl<T> extends AbstractExecutionStrategyChain<T> {

    private final ExecutionStrategy<T> firstExecutionStrategy;
    private final Executionstrategy<T> secondExecutionStrategy;

    public ExecutionStrategyChainImpl(ExecutionStrategy<T> first, ExecutionStrategy<T> second) {
        if(first == null) throw new NullPointerException();
        this.firstExecutionStrategy = first;
        this.secondExecutionStrategy = second;
    }

    public ExecutionStrategyChainImpl(ExecutionStrategy<T> first) {
        this(first, null);
    }

    @Override
    public final T execute(T item) {
        if(item == null) {
            return null;
        }

        T result = firstExecutionStrategy.execute(item);
        if(result != null && secondExecutionStrategy != null) {
            result = secondExecutionStrategy.execute(result);
        }
        return result;
    }
}


public class PreProcessor<T> implements ExecutionStrategy<T> {

    public PreProcessor() {
    }

    @Override
    public T execute(T item) {
       //Do some pre-processing of item
       return item;
    }
}


public class PostProcessor<T> implements ExecutionStrategy<T> {

    public PostProcessor() {
    }

    @Override
    public T execute(T item) {
       //Do some post-processing of item
       return item;
    }
}


public class MyNormalProcessor<T> extends AbstractExecutionStrategyChain<T> {

    public MyNormalProcessor() {
    }

    @Override
    public T execute(T item) {
       //Do something normal with the item
       return item;
    }
}


public static final ExecutionStrategy<StoreItem> COMPLEX_EXECUTION_STRATEGY = 
    ExecutionStrategyChain<StoreItem>.newInstance(new PreProcessor<StoreItem>())
                                     .chainTo(new MyNormalProcessor<StoreItem>())
                                     .chainTo(new PostProcessor<StoreItem>());