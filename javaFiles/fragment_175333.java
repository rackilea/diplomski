public final class CompoundRunnable implements Runnable
{
    private final Iterable<Runnable> runnables;

    public CompoundRunnable(Iterable<Runnable> runnables)
    {
        // From Guava. Easy enough to do by hand if necessary
        this.runnables = Lists.newArrayList(runnables);
    }

    public CompoundRunnable(Runnable... runnables)
    {
        this(Arrays.asList(runnables));
    }

    @Override
    public void run()
    {
        for (Runnable runnable : runnables)
        {
             runnable.run();
        }
    }
}