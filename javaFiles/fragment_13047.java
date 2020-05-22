protected synchronized boolean isOpen()
{
    lock.interested();
    while(!lock.isReady())
    {
        wait(); // now the next thread can enter isOpen()
    }
    notify(); // releases the previous thread wait()ing in this method
    return true;
 }