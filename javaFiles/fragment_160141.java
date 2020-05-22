public class MultiRunnable implements Runnable
{
    private final List<Runnable> runnables;

    public MultiRunnable(List<Runnable> runnables)
    {
        this.runnables = runnables;
    }

    public void run()
    {
        for (Runnable runnable : runnables)
        {
             runnable.run();
        }
    }
}