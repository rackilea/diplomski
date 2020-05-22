import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.MDC;

/**
 * A {@link ForkJoinPool} that inherits MDC contexts from the thread that queues a task.
 *
 * @author Gili Tzabari
 */
public final class MdcForkJoinPool extends ForkJoinPool
{
    /**
     * Creates a new MdcForkJoinPool.
     *
     * @param parallelism the parallelism level. For default value, use {@link java.lang.Runtime#availableProcessors}.
     * @param factory     the factory for creating new threads. For default value, use
     *                    {@link #defaultForkJoinWorkerThreadFactory}.
     * @param handler     the handler for internal worker threads that terminate due to unrecoverable errors encountered
     *                    while executing tasks. For default value, use {@code null}.
     * @param asyncMode   if true, establishes local first-in-first-out scheduling mode for forked tasks that are never
     *                    joined. This mode may be more appropriate than default locally stack-based mode in applications
     *                    in which worker threads only process event-style asynchronous tasks. For default value, use
     *                    {@code false}.
     * @throws IllegalArgumentException if parallelism less than or equal to zero, or greater than implementation limit
     * @throws NullPointerException     if the factory is null
     * @throws SecurityException        if a security manager exists and the caller is not permitted to modify threads
     *                                  because it does not hold
     *                                  {@link java.lang.RuntimePermission}{@code ("modifyThread")}
     */
    public MdcForkJoinPool(int parallelism, ForkJoinWorkerThreadFactory factory, UncaughtExceptionHandler handler,
        boolean asyncMode)
    {
        super(parallelism, factory, handler, asyncMode);
    }

    @Override
    public void execute(ForkJoinTask<?> task)
    {
        // See http://stackoverflow.com/a/19329668/14731
        super.execute(wrap(task, MDC.getCopyOfContextMap()));
    }

    @Override
    public void execute(Runnable task)
    {
        // See http://stackoverflow.com/a/19329668/14731
        super.execute(wrap(task, MDC.getCopyOfContextMap()));
    }

    private <T> ForkJoinTask<T> wrap(ForkJoinTask<T> task, Map<String, String> newContext)
    {
        return new ForkJoinTask<T>()
        {
            private static final long serialVersionUID = 1L;
            /**
             * If non-null, overrides the value returned by the underlying task.
             */
            private final AtomicReference<T> override = new AtomicReference<>();

            @Override
            public T getRawResult()
            {
                T result = override.get();
                if (result != null)
                    return result;
                return task.getRawResult();
            }

            @Override
            protected void setRawResult(T value)
            {
                override.set(value);
            }

            @Override
            protected boolean exec()
            {
                // According to ForkJoinTask.fork() "it is a usage error to fork a task more than once unless it has completed
                // and been reinitialized". We therefore assume that this method does not have to be thread-safe.
                Map<String, String> oldContext = beforeExecution(newContext);
                try
                {
                    task.invoke();
                    return true;
                }
                finally
                {
                    afterExecution(oldContext);
                }
            }
        };
    }

    private Runnable wrap(Runnable task, Map<String, String> newContext)
    {
        return () ->
        {
            Map<String, String> oldContext = beforeExecution(newContext);
            try
            {
                task.run();
            }
            finally
            {
                afterExecution(oldContext);
            }
        };
    }

    /**
     * Invoked before running a task.
     *
     * @param newValue the new MDC context
     * @return the old MDC context
     */
    private Map<String, String> beforeExecution(Map<String, String> newValue)
    {
        Map<String, String> previous = MDC.getCopyOfContextMap();
        if (newValue == null)
            MDC.clear();
        else
            MDC.setContextMap(newValue);
        return previous;
    }

    /**
     * Invoked after running a task.
     *
     * @param oldValue the old MDC context
     */
    private void afterExecution(Map<String, String> oldValue)
    {
        if (oldValue == null)
            MDC.clear();
        else
            MDC.setContextMap(oldValue);
    }
}