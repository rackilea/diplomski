/**
 * A "Single Last-In-First-Out Executor".
 * <p>
 * It maintains a queue of <b>one</b> task and only one task may execute simultaneously,
 * submitting a new task to {@link #execute(Runnable)} will discard any previous submitted not yet started tasks.
 */
public class SingleLIFOExecutor implements Executor
{
    private final ThreadPoolExecutor executor;
    private Runnable lastCommand;

    public SingleLIFOExecutor()
    {
        executor = new ThreadPoolExecutor(0, 1, 0, MILLISECONDS, new ArrayBlockingQueue<Runnable>(1));
    }

    /**
     * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
     */
    @Override
    public void execute(Runnable command)
    {
        executor.remove(lastCommand);
        lastCommand = command;
        executor.execute(command);
    }
}