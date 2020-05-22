public synchronized void put(E i)
    {
        msgQ.add(i);
        System.out.println("Sender put element : " + i);
        notify();
        System.out.println(Thread.currentThread().getName() + " : notifying other threads...");

    }



public synchronized E get()
{
    if(msgQ.isEmpty())
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " : waiting for new element..");
            notify();
            wait();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    return msgQ.remove();
}