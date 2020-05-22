import java.util.concurrent.ExecutorService;

class Unsafe
{

}

class SafePublication
{
    private final ExecutorService mExecutor = null;

    public void publish(final Unsafe unsafe)
    {
        mExecutor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                // do something with unsafe
                System.out.println(unsafe);
            }
        });
    }
}