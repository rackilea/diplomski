public final class CompoundRunnable implements Runnable
{
    private final Runnable first;
    private final Runnable second;

    public CompoundRunnable(Runnable first, Runnable second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public void run()
    {
        first.run();
        second.run();
    }
}