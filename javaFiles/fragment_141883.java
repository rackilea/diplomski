final Semaphore s = new Semaphore(5);
for (int i = 0; i < 20; ++i)
{
    final int j = i;

    s.acquire();

    new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            try
            {
                System.out.println("Thread " + j + " starts.");
                Thread.sleep(1000);
                System.out.println("Thread " + j + " ends.");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                s.release();
            }
        }

    }).start();
}