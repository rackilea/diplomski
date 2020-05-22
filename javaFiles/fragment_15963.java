public class RunMeSumThread extends Thread
{
    public RunMeSumThread(final int n)
    {
        super(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < n; i++) 
                {
                    System.out.print(i);
                    System.out.print(" | ");
                    System.out.print(Thread.currentThread().getName());
                    System.out.println();
                }
            }
        });
    }
}