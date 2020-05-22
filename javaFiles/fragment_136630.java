public class DelayBlockingQueue<E extends Delayed>
{
    private final DelayQueue<E> delayQ = new DelayQueue<E>();
    private final Semaphore available;

    public DelayBlockingQueue(int capacity)
    {
        available = new Semaphore(capacity, true);
    }

    public void offer(E e) throws InterruptedException
    {
        available.acquire();
        delayQ.offer(e);
    }

    public E poll()
    {
        E e = delayQ.poll();
        if (e != null)
        {
            available.release();
        }
        return e;
    }
}