private class MyThread extends Thread
{
    private static Lock lock = new ReentrantLock();

    public void run()
    {
        if (MyThread.lock.tryLock())
        {
            try
            {
                // TODO something
            }
            finally
            {
                MyThread.lock.unlock();
            }
        }
    }
}