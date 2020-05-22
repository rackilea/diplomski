// A semaphore initialized with no permits
final Semaphore runnableExecuting = new Sempahore(0);

final Runnable refresh = new Runnable()
{
    @Override
    public void run()
    {
        // Release one permit.  This should unblock the thread
        // scheduled this task.  After the initial releasing
        // the semaphore is essentially unneeded
        runnableExecuting.release();

        // Your code
    }
}

// After executor scheduling

// Attempt to acquire a permit, which the semphore initially has none.
// This will block until a permit becomes available
runnableExecuting.acquire();