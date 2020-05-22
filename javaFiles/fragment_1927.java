import java.util.Map;
import java.util.concurrent.CountedCompleter;
import org.slf4j.MDC;

/**
 * A {@link CountedCompleter} that inherits MDC contexts from the thread that queues a task.
 *
 * @author Gili Tzabari
 * @param <T> The result type returned by this task's {@code get} method
 */
public abstract class MdcCountedCompleter<T> extends CountedCompleter<T>
{
    private static final long serialVersionUID = 1L;
    private final Map<String, String> newContext;

    /**
     * Creates a new MdcCountedCompleter instance using the MDC context of the current thread.
     */
    protected MdcCountedCompleter()
    {
        this(null);
    }

    /**
     * Creates a new MdcCountedCompleter instance using the MDC context of the current thread.
     *
     * @param completer this task's completer; {@code null} if none
     */
    protected MdcCountedCompleter(CountedCompleter<?> completer)
    {
        super(completer);
        this.newContext = MDC.getCopyOfContextMap();
    }

    /**
     * The main computation performed by this task.
     */
    protected abstract void computeWithContext();

    @Override
    public final void compute()
    {
        Map<String, String> oldContext = beforeExecution(newContext);
        try
        {
            computeWithContext();
        }
        finally
        {
            afterExecution(oldContext);
        }
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