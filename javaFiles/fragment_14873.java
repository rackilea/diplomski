class ThreadsInSequence extends Thread
{
    private Object lock, unlock;
    ThreadsInSequence(Object lock, Object unlock)
    {
        this.lock = lock;
        this.unlock = unlock;
    }
    public void run()
    {
        synchronized(lock)
        {
            for(int i = 0; i < strs; ++i)
            {
                waiter();
                if(array[0] == this)
                {
                    System.out.println(i+1);
                }
                System.out.print(getName() + ' ');
                ++count;
                if(array[thrs-1] == this)
                {
                    System.out.println();
                }
                if(unlock != lock)
                {
                    synchronized(unlock)
                    {
                        unlock.notify();
                    }
                }
            }
        }
    }
    void waiter()
    {
        try
        {
            lock.wait();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Thread array[];
    public static Object locks[];
    public static int count, strs, thrs;
    public static void main(String args[])
    {
        thrs = 3;
        strs = 6;
        count = 0;
        locks = new Object[thrs];
        array = new Thread[thrs];
        for(int i = 0; i < thrs; ++i)
        {
            locks[i] = new Object();
        }
        for(int i = 0; i < thrs; ++i)
        {
            if(i != thrs-1)
            {
                array[i] = new ThreadsInSequence(locks[i],locks[i+1]);
            }else
            {
                array[i] = new ThreadsInSequence(locks[i],locks[0]);
            }
            array[i].start();
        }
        synchronized(locks[0]) {
            locks[0].notify();
        }
    }
}