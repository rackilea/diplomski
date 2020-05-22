public static void main(String[] args)
{
    final Object lock = new Object();
    for (int p = 0; p < 10; p++)
    {
        //You start each thread. They all go to sleep for 200ms.

        final int i = p;
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("notify " + i);
                synchronized (lock)
                {
                    lock.notify();
                }
            }
        }).start();
    }
    //At this point, all the thread are sleeping.



    Integer counter = 0;
    synchronized (lock)//The main thread acquire the lock, so even if the other thread wakes up, they will wait for the lock
    {
        try
        {
            while (true)
            {
                System.out.println("Before wait");
                if (counter == 10)// wait until all threads ends
                    break;
                lock.wait();// Object.wait() will release the lock on the object.
// So 1 of the thread will acquire the lock, call notify(), and release the lock.
 // But you have no guarantee that the main thread will reacquire the lock right away !!     
//its possible that all remaining waiting thread gets the lock and call notify(), before the main thread get 
//a chance to continue. This is why, you may end up with a deadlock

                counter += 1;

                System.out.println("After wait");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    System.out.println("End");
}