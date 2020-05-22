static final AtomicBoolean flag = new AtomicBoolean(false); // synchronize on this, and also store the fact. It is static so that if this is in a Runnable instance will not appear to reset the fact. Don't use the Boolean wrapper, for the value of the flag might be different in certain cases.

public void lala(Action doThis)
{
    synchronized (flag) // synchronize on the flag so that other threads arriving here, will be forced to wait
    {
        if(!flag.get()) // This condition is true only for the first thread.
        {
           doX();
           flag.set(true); //set the flag so that other threads will not invoke doX.
        }
    }
    ...
    doCommonWork();
    ...
}